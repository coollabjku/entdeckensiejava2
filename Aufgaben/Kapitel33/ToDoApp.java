package Aufgaben.Kapitel33;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * An application to manage ToDo-Lists.
 * 
 * @author ESOP Team 2012
 */
public class ToDoApp {
	private ListManager listManager;
	private File listFile;
	private JButton saveButton = new JButton("Save");
	private JDialog frame;

	private JTable table;
	private ToDoTableModel model;

	private ColorRenderer whiteRenderer = new ColorRenderer(Color.WHITE);
	private ColorRenderer greenRenderer = new ColorRenderer(new Color(240, 255, 200));
	private boolean entryChanged = false;
	private String unsavedNewListFileName = "";

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ToDoApp().setUpFrame();
			}
		});
	}

	private void setUpFrame() {
		frame = new JDialog(new JFrame(), true);
		frame.setLocation(20, 20);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = 0;
				if (entryChanged) {
					String message = "Would you like to save changes?";
					String[] choices = { "Yes", "No", "Cancel" };
					result = JOptionPane.showOptionDialog(frame, message, "Warning", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE, null, choices, choices[0]);
					if (result == 0) {
						if (!unsavedNewListFileName.equals("")) {
							String dirPath = "";
							dirPath = prepareConfig();
							listFile = new File(dirPath + "/" + unsavedNewListFileName + ".todo");
							unsavedNewListFileName = "";
						}
						writeFileFromList(listFile, false);
					}
				}
				if (result != 2) {
					// write the config file to save the last used file name
					writeFileFromList(new File(prepareConfig() + "/.conf"), true);
					System.exit(0);
				}
			}
		});
		frame.add(createAndInitContentPane());
		frame.pack();

		frame.setVisible(true);
	}

	private String prepareConfig() {
		try {
			return System.getProperty("user.dir");
		} catch (SecurityException se) {
			String message = "A Java security manager exists and its checkPropertyAccess method does not \n"
					+ "allow access to read file paths. Contact your teacher for assistance! \n"
					+ "Need to exit program... sorry...";
			String[] choices = { "Ok" };
			JOptionPane.showOptionDialog(frame, message, "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE,
					null, choices, choices[0]);
			System.exit(-1);
			return null;
		}
	}

	private JPanel createAndInitContentPane() {
		// first we need to get the last list that was shown,
		// this information is found in the "todo.conf" file.
		String dirPath = "";
		dirPath = prepareConfig();
		readFileAndCreateList(dirPath + "/todo.conf", true);
		// now we should have the ListManager set up and ready to go!
		// first, call the ListManager to get the data for the table view.
		Vector<String> headers = listManager.getAttributeNames();
		Vector<Vector<String>> data = listManager.sortToDoEntries(-1);
		model = new ToDoTableModel(headers, data);

		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public TableCellRenderer getCellRenderer(int row, int column) {
				if (row % 2 != 0) {
					return greenRenderer;
				} else {
					return whiteRenderer;
				}
			}
		};

		table.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent tme) {
				entryChanged = true;
				saveButton.setEnabled(true);
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);

		Dimension d = table.getPreferredSize();
		if (d.height < 100) {
			d.height = 100;
		}
		if (d.width > 1000) {
			d.width = 800;
		}

		table.setPreferredScrollableViewportSize(d);

		JTextField jtf = new JTextField();
		TableColumn textColumn = table.getColumnModel().getColumn(1);
		textColumn.setCellEditor(new DeadlineCellEditor(jtf, table));

		TableColumn column = null;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0 || i == 1) {
				column.setPreferredWidth(column.getMinWidth() + 100);
				column.setMaxWidth(column.getPreferredWidth() + 50);
			} else {
				column.setPreferredWidth(450);
			}
		}

		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(10, 10, 0, 10);
		gc.fill = GridBagConstraints.BOTH;

		pane.add(scrollPane, gc);

		// setup the controls
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridBagLayout());
		JPanel sortPanel = new JPanel();
		sortPanel.setBorder(BorderFactory.createTitledBorder("Sort by:"));
		sortPanel.setLayout(new GridBagLayout());
		JRadioButton creationDateSortButton = new JRadioButton("Creation date");
		JRadioButton deadlineDateSortButton = new JRadioButton("Deadline date");
		JRadioButton textSortButton = new JRadioButton("Text");

		ButtonGroup group = new ButtonGroup();
		group.add(creationDateSortButton);
		group.add(deadlineDateSortButton);
		group.add(textSortButton);

		gc.weighty = 0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		sortPanel.add(creationDateSortButton, gc);
		gc.gridy++;
		sortPanel.add(deadlineDateSortButton, gc);
		gc.gridy++;
		sortPanel.add(textSortButton, gc);

		gc.gridx = 0;
		gc.gridy = 0;
		middlePanel.add(sortPanel, gc);

		JButton newListButton = new JButton("New List...");
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.insets = new Insets(10, 10, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		pane.add(middlePanel, gc);

		creationDateSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sortList(ListManager.CREATIONDATE_SORT);
			}
		});

		deadlineDateSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sortList(ListManager.DEADLINEDATE_SORT);
			}
		});

		textSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sortList(ListManager.TEXT_SORT);
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		final JButton deleteButton = new JButton("Delete entries");
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				deleteButton.setEnabled(true);
			}
		});
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int[] rowSel = table.getSelectedRows();
				if (rowSel.length > 0) {
					String message = "";
					if (rowSel.length == 1) {
						message = "Do you really want do delete the marked entry?";
					} else {
						message = "Do you really want to delete the " + rowSel.length + " marked entries?";
					}
					String[] choices = { "Yes", "No", "Cancel" };
					int result = JOptionPane.showOptionDialog(frame, message, "Warning",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, choices, choices[0]);
					if (result == 0) {
						entryChanged = true;
						for (int i = 0; i < rowSel.length; i++) {
							model.removeRow(table.getSelectedRow());
						}
					}
				}
			}
		});

		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets(0, 0, 0, 0);
		buttonPanel.add(deleteButton, gc);
		gc.gridx++;
		buttonPanel.add(Box.createRigidArea(new Dimension(40, 10)), gc);

		JButton openButton = new JButton("Open list...");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (entryChanged) {
					String message = "Would you like to save changes before opening\n" + "a new TODO list?";
					String[] choices = { "Yes", "No", "Cancel" };
					int result = JOptionPane.showOptionDialog(frame, message, "Warning",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, choices, choices[0]);
					if (result == 0) {
						writeFileFromList(listFile, false);
						entryChanged = false;
						saveButton.setEnabled(false);
					} else if (result == 1) {
						// entryChanged = false;
					} else {
						return;
					}
				}
				String dirPath = prepareConfig();
				JFileChooser chooser = new JFileChooser(dirPath);

				chooser.setFileFilter(new FileNameExtensionFilter("Esop List File (*.todo)", "todo"));
				String[] choices = { "Ok", "Cancel" };
				boolean validSelection = false;
				int retValue = -1;
				while (!validSelection) {
					int choice = chooser.showOpenDialog(frame);// == JFileChooser.APPROVE_OPTION
					if (choice == JFileChooser.APPROVE_OPTION) {
						String selectedFile = chooser.getSelectedFile().getAbsolutePath();
						int length = selectedFile.length();
						if (!selectedFile.substring(length - 5, length).equals(".todo")) {
							String message = "The selected file is not a valid TODO list file!\n"
									+ "You can only open .todo files!\n" + "Do you want to try another file?";
							retValue = JOptionPane.showOptionDialog(frame, message, "Error", JOptionPane.OK_OPTION,
									JOptionPane.ERROR_MESSAGE, null, choices, choices[0]);
							if (retValue != JOptionPane.OK_OPTION) {
								validSelection = true;
							}
						} else {
							validSelection = true;
							retValue = 0;
						}
					} else {
						validSelection = true;
					}
				}
				if (retValue == 0) {
					readFileAndCreateList(chooser.getSelectedFile().getAbsolutePath(), false);
					int nrRows = model.getRowCount();
					for (int i = 0; i < nrRows; i++) {
						model.removeRow(0);
					}
					Vector<Vector<String>> vec = listManager.sortToDoEntries(-1);
					for (Vector<String> v : vec) {
						model.addRow(v);
					}
					entryChanged = false;
					saveButton.setEnabled(false);
				}
			}
		});
		gc.gridx++;
		gc.insets = new Insets(0, 5, 0, 0);
		buttonPanel.add(openButton, gc);

		JButton addButton = new JButton("New Entry...");
		gc.gridx++;
		buttonPanel.add(addButton, gc);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				final JTextArea textArea = new JTextArea(4, 20);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				JScrollPane scrollPane = new JScrollPane(textArea);
				final JTextField deadlineField = new JTextField();
				deadlineField.setColumns(7);
				JPanel panel = new JPanel();

				panel.setLayout(new GridBagLayout());
				GridBagConstraints gc = new GridBagConstraints();
				gc.gridx = 0;
				gc.gridy = 0;
				gc.weightx = 10;
				gc.weighty = 10;
				gc.anchor = GridBagConstraints.NORTHEAST;
				gc.insets = new Insets(10, 0, 0, 10);
				gc.fill = GridBagConstraints.NONE;
				panel.add(new JLabel("Text:"), gc);
				gc.gridx++;
				gc.weightx = 10;
				gc.weighty = 10;

				panel.add(scrollPane, gc);
				gc.gridx = 0;
				gc.gridy++;
				gc.anchor = GridBagConstraints.EAST;
				gc.insets = new Insets(10, 10, 0, 10);
				panel.add(new JLabel("Deadline:"), gc);
				gc.gridx++;
				gc.insets = new Insets(10, 0, 0, 10);
				gc.anchor = GridBagConstraints.NORTHWEST;
				panel.add(deadlineField, gc);

				JButton okButton = new JButton("Ok");
				JButton cancelButton = new JButton("Cancel");

				JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
				buttonPanel.add(cancelButton);
				buttonPanel.add(okButton);

				gc.gridy++;
				gc.anchor = GridBagConstraints.EAST;
				gc.insets = new Insets(10, 10, 10, 10);
				panel.add(buttonPanel, gc);

				final JDialog entryFrame = new JDialog(frame, "New Entry", true);
				entryFrame.setResizable(false);
				entryFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				entryFrame.add(panel);
				entryFrame.setLocationRelativeTo(frame);

				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						entryFrame.dispose();
					}
				});

				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						Vector<String> vec = new Vector<String>();
						String creationDateString = ToDoDate.getTodaysDate().toString();
						String deadlineString = deadlineField.getText();
						vec.add(creationDateString);
						vec.add(deadlineString);
						vec.add(textArea.getText());
						if (!deadlineString.equals("")) {
							boolean inputOk = true;
							try {
								// do this to check that a valid ToDoDate string is passed to the ToDoDate
								// constructor!
								Integer.valueOf(deadlineString.substring(0, 2)).intValue();
								Integer.valueOf(deadlineString.substring(3, 5)).intValue();
								Integer.valueOf(deadlineString.substring(6, deadlineString.length())).intValue();
							} catch (RuntimeException e) {
								inputOk = false;
							}
							if (deadlineString.length() != 10) {
								inputOk = false;
							} else if (deadlineString.charAt(2) != '.' || deadlineString.charAt(5) != '.') {
								inputOk = false;
							}
							if (!inputOk) {
								String[] choices = { "Ok" };
								JOptionPane.showOptionDialog(frame,
										"Not a valid date format! \nPlease " + "use: DD.MM.YYYY", "Error",
										JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, choices, choices[0]);
								return;
							}
							ToDoDate test = getValidDeadlineDate(creationDateString, deadlineString);
							if (test == null) {
								return;
							}
						}
						model.addRow(vec);
						entryFrame.dispose();
					}
				});
				entryFrame.pack();
				entryFrame.setVisible(true);
			}
		});

		newListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (entryChanged) {
					String message = "Would you like to save changes before opening\n" + "a new TODO list?";
					String[] choices = { "Yes", "No", "Cancel" };
					int result = JOptionPane.showOptionDialog(frame, message, "Warning",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, choices, choices[0]);
					if (result == 0) {
						if (!unsavedNewListFileName.equals("")) {
							String dirPath = "";
							dirPath = prepareConfig();
							listFile = new File(dirPath + "/" + unsavedNewListFileName + ".todo");
							unsavedNewListFileName = "";
						}
						writeFileFromList(listFile, false);
						entryChanged = false;
						saveButton.setEnabled(false);
					} else if (result == 1) {
					} else {
						return;
					}
				}
				final JTextField textField = new JTextField();
				textField.setColumns(14);
				JPanel textPanel = new JPanel();

				textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
				textPanel.add(new JLabel("List name:"));
				textPanel.add(Box.createRigidArea(new Dimension(8, 0)));
				textPanel.add(textField);

				JButton okButton = new JButton("Ok");
				JButton cancelButton = new JButton("Cancel");
				JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
				buttonPanel.add(cancelButton);
				buttonPanel.add(okButton);

				JPanel contentPanel = new JPanel();
				contentPanel.setLayout(new GridBagLayout());
				GridBagConstraints gc = new GridBagConstraints();
				gc.gridx = 0;
				gc.gridy = 0;
				gc.insets = new Insets(10, 10, 0, 10);
				gc.anchor = GridBagConstraints.WEST;
				contentPanel.add(textPanel, gc);

				gc.gridy++;
				gc.anchor = GridBagConstraints.EAST;
				gc.insets = new Insets(10, 10, 10, 10);
				contentPanel.add(buttonPanel, gc);

				final JDialog entryFrame = new JDialog(frame, "New List", true);
				entryFrame.setResizable(false);
				entryFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				entryFrame.add(contentPanel);
				entryFrame.setLocationRelativeTo(frame);

				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						entryFrame.dispose();
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						boolean acceptable = true;
						String s = textField.getText();
						for (int i = s.length(); i-- > 0;) {
							if (!Character.isLetterOrDigit(s.charAt(i))) {
								acceptable = false;
								break;
							}
						}
						if (s.length() <= 0) {
							acceptable = false;
						}
						if (!acceptable) {
							String[] choices = { "Ok" };
							String message = "The file name may only contain letters or digits!\n"
									+ "Please enter a new file name.";
							JOptionPane.showOptionDialog(frame, message, "Error", JOptionPane.OK_OPTION,
									JOptionPane.ERROR_MESSAGE, null, choices, choices[0]);
							textField.requestFocus();
							textField.selectAll();
						} else {
							// now clear the model!
							int nrRows = model.getRowCount();
							for (int i = 0; i < nrRows; i++) {
								model.removeRow(0);
							}

							frame.setTitle("ToDo-List: " + textField.getText());
							entryFrame.dispose();
							// String dirPath = "";
							// dirPath = prepareConfig();
							// listFile = new File(dirPath + "/" + textField.getText() + ".todo");
							unsavedNewListFileName = textField.getText();
							entryChanged = true;
							saveButton.setEnabled(true);
						}
					}
				});
				entryFrame.pack();
				entryFrame.setVisible(true);
			}
		});

		gc.gridx++;
		buttonPanel.add(newListButton, gc);

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!unsavedNewListFileName.equals("")) {
					String dirPath = "";
					dirPath = prepareConfig();
					listFile = new File(dirPath + "/" + unsavedNewListFileName + ".todo");
					unsavedNewListFileName = "";
				}
				writeFileFromList(listFile, false);
			}
		});
		saveButton.setEnabled(false);
		gc.gridx++;
		buttonPanel.add(saveButton, gc);

		int widestButton = deleteButton.getPreferredSize().width;
		if (saveButton.getPreferredSize().width > widestButton)
			widestButton = saveButton.getPreferredSize().width;
		if (openButton.getPreferredSize().width > widestButton)
			widestButton = openButton.getPreferredSize().width;
		if (addButton.getPreferredSize().width > widestButton)
			widestButton = addButton.getPreferredSize().width;

		Dimension dd = new Dimension(widestButton, deleteButton.getPreferredSize().height);
		deleteButton.setPreferredSize(dd);
		saveButton.setPreferredSize(dd);
		openButton.setPreferredSize(dd);
		addButton.setPreferredSize(dd);
		newListButton.setPreferredSize(dd);
		deleteButton.setMinimumSize(dd);
		saveButton.setMinimumSize(dd);
		openButton.setMinimumSize(dd);
		addButton.setMinimumSize(dd);
		newListButton.setMinimumSize(dd);

		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = 0;
		gc.weightx = 80;
		gc.insets = new Insets(10, 10, 10, 10);
		gc.anchor = GridBagConstraints.NORTHWEST;
		pane.add(buttonPanel, gc);
		return pane;
	}

	private void sortList(int sortType) {
		if (entryChanged) {
			Vector<Vector<String>> temp = new Vector<Vector<String>>();
			for (int row = 0; row < table.getRowCount(); row++) {
				Vector<String> tempStrings = new Vector<String>();
				for (int col = 0; col < table.getColumnCount(); col++) {
					model.setValueAt(table.getValueAt(row, col), row, col);
					tempStrings.add(table.getValueAt(row, col).toString());
				}
				temp.add(tempStrings);
			}
			entryChanged = false;
			saveButton.setEnabled(false);
			// now all changes are saved in the model. transfer the changes
			// to the listmanager and its ToDoList.
			listManager.setToDoList(temp);
		}

		int nrRows = model.getRowCount();
		for (int i = 0; i < nrRows; i++) {
			model.removeRow(0);
		}
		Vector<Vector<String>> vec = listManager.sortToDoEntries(sortType);
		for (Vector<String> v : vec) {
			model.addRow(v);
		}
	}

	private void readFileAndCreateList(String filePath, boolean readConfFile) {
		listFile = new File(filePath);
		String dataFilePath = "";
		String message = "";
		Vector<String[]> entries = new Vector<String[]>();
		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(listFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit odd...: it returns the content of a line MINUS the newline.
				 * it returns null only for the END of the stream. it returns an empty String if
				 * two newlines appear in a row.
				 */
				while ((line = input.readLine()) != null) {
					if (!readConfFile) {
						String[] arr = line.split(";");
						if (arr.length == 3) {
							entries.add(arr);
						}
					} else {
						// we're reading the confFile, should only be one line of
						// information here!
						String[] arr = line.split(";");
						if (!arr[0].substring(0, 1).equals("#")) {
							// this is not a comment line, process this line
							dataFilePath = arr[0];
							// in case this is the first time the app is started
							// on a new computer, the todo.conf file reads "empty"
							if (dataFilePath.equals("empty")) {
								dataFilePath = prepareConfig() + "/private1.todo";
							}
						}
					}
				}
				// only create data if we've read a data file!
				if (!readConfFile) {
					listManager = new ListManager(entries);
					int index = filePath.lastIndexOf("/");
					String fileName = filePath.substring(index + 1, filePath.length() - 5);
					frame.setTitle("ToDo-List: " + fileName);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			if (readConfFile) {
				ex.printStackTrace();
				message = "A problem occured when reading the configuration file\n" + filePath + ".\n\n"
						+ "Please check that the file exists and contains a single line (ignoring\n"
						+ "all comment lines starting with #) containing a valid path to a\n"
						+ "valid TODO list file (with the file extension .todo).\n\n"
						+ "Need to exit program... sorry...";
			} else {
				message = "A problem occured when trying to read the data file\n" + filePath + ".\n\n"
						+ "Please check that the file exists and contains TODO list information!\n\n"
						+ "Need to exit program... sorry...";
				ex.printStackTrace();
			}
		} catch (NumberFormatException nfe) {
			message = "A problem occured when trying to read the data file\n" + filePath + ".\n"
					+ "This seems to be a corrupt .todo file.\n" + "Make sure you don't manually edit .todo files!\n\n"
					+ "Need to exit program... sorry...";
		} catch (IllegalArgumentException iae) {
			message = "A problem occured while reading file\n" + filePath + ".\n"
					+ "The file contains one or more TODO list entries with a deadline date\n"
					+ "that is before the creation date of the corresponding entry.\n"
					+ "Make sure you don't manually edit .todo files!\n\n" + "Need to exit program... sorry...";
			iae.printStackTrace();
		}
		if (!message.equals("")) {
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		// in case we have successfully found a file name in the config file, read the
		// data from
		// the indicated file and generate a ToDoList!
		if (readConfFile)
			readFileAndCreateList(dataFilePath, false);
	}

	private void writeFileFromList(File file, boolean writeConfFile) {
		Writer output = null;
		boolean writeError = false;
		try {
			output = new BufferedWriter(new FileWriter(file));
			if (!writeConfFile) {
				String saveString = "";
				String dateString = "";
				// write the first comment line
				saveString = "#This is a TODO list file for the ToDoApp. Don't manually edit it!\n";
				output.write(saveString);
				saveString = "";
				for (int row = 0; row < table.getRowCount(); row++) {
					for (int col = 0; col < table.getColumnCount(); col++) {
						if (col == 0 || col == 1) {
							dateString = (String) table.getValueAt(row, col);
							saveString = saveString + dateString.replace(".", "") + ";";
						} else {
							// saveString = col!=table.getColumnCount()-1?(saveString +
							// table.getValueAt(row, col) + ";"):
							// (saveString + table.getValueAt(row, col));
							saveString = saveString + table.getValueAt(row, col);
							saveString = saveString.replaceAll("[\u0000-\u001f]", "");
						}
					}
					output.write(saveString + "\n");
					saveString = "";
				}

				Vector<Vector<String>> temp = new Vector<Vector<String>>();
				for (int row = 0; row < table.getRowCount(); row++) {
					Vector<String> tempStrings = new Vector<String>();
					for (int col = 0; col < table.getColumnCount(); col++) {
						model.setValueAt(table.getValueAt(row, col), row, col);
						tempStrings.add(table.getValueAt(row, col).toString());
					}
					temp.add(tempStrings);
				}
				entryChanged = false;
				saveButton.setEnabled(false);
				// now all changes are saved in the model. transfer the changes
				// to the listmanager and its ToDoList.
				listManager.setToDoList(temp);

			} else {
				String saveString = "# This is the 'configuration' file for the ToDoApp.\n"
						+ "# It should only contain one single line of information, specifying the file path to the ToDoList-data file\n"
						+ "# that was used last the ToDoApp was running!" + "Do not manually modify this file!!!!!!\n";
				saveString = saveString + listFile;
				output.write(saveString);
			}
		} catch (IOException e) {
			String message = "Unknown error while writing to file\n\n" + file + "\n\n"
					+ "Sorry, need to exit program although some\n" + "changes may have not been saved!";
			JOptionPane.showMessageDialog(null, message, "Fehler", JOptionPane.ERROR_MESSAGE);
			writeError = true;
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				System.out.println("I/O error occurred while closing BufferedWriter after a failure on writing...");
				e.printStackTrace();
			}
			saveButton.setEnabled(false);
			entryChanged = false;
			if (writeError) {
				System.exit(-1);
			}
		}
	}

	private ToDoDate getValidDeadlineDate(String creationDateString, String deadlineString) {
		ToDoDate deadlineDate = null;
		ToDoDate creationDate = null;
		try {
			creationDate = new ToDoDate(creationDateString);
			deadlineDate = new ToDoDate(deadlineString);
			new ToDoEntry(creationDate, deadlineDate, "");
		} catch (ToDoDateException e) {
			// ToDoDateException throw by ToDoDate constructor if not a valid date
			String[] choices = { "Ok" };
			JOptionPane.showOptionDialog(frame, e.getMessage(), "Error", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, choices, choices[0]);
			return null;
		} catch (IllegalArgumentException iae) {
			// IllegalArgumentException throw by ToDoEntry constructor when deadline before
			// creation date
			String[] choices = { "Ok" };
			JOptionPane.showOptionDialog(frame, iae.getMessage(), "Error", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, choices, choices[0]);
			return null;
		}
		return deadlineDate;
	}

	// INNER CLASSES
	private class DeadlineCellEditor extends DefaultCellEditor {
		private static final long serialVersionUID = 1L;

		public DeadlineCellEditor(JTextField arg, JTable table) {
			super(arg);
		}

		@Override
		public boolean stopCellEditing() {
			String value = (String) this.getCellEditorValue();
			if (!value.equals("")) {
				String creationDateString = (String) table.getValueAt(table.getSelectedRow(), 0);
				String deadlineDateString = value;
				boolean inputOk = true;
				try {
					// do this to check that a valid ToDoDate string is passed to the ToDoDate
					// constructor!
					Integer.valueOf(deadlineDateString.substring(0, 2)).intValue();
					Integer.valueOf(deadlineDateString.substring(3, 5)).intValue();
					Integer.valueOf(deadlineDateString.substring(6, deadlineDateString.length())).intValue();
				} catch (RuntimeException e) {
					inputOk = false;
				}
				if (deadlineDateString.length() != 10) {
					inputOk = false;
				}
				if (deadlineDateString.charAt(2) != '.' || deadlineDateString.charAt(5) != '.') {
					inputOk = false;
				}
				if (!inputOk) {
					String[] choices = { "Ok" };
					JOptionPane.showOptionDialog(frame, "Not a valid date format! \nPlease " + "use: DD.MM.YYYY",
							"Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, choices, choices[0]);
					return false;
				}
				if (getValidDeadlineDate(creationDateString, deadlineDateString) == null) {
					return false;
				}
			}
			return super.stopCellEditing();
		}
	}

	private class ColorRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		public ColorRenderer(Color c) {
			super();
			setBackground(c);
		}
	}

	private class ToDoTableModel extends DefaultTableModel {
		private static final long serialVersionUID = 1L;

		public ToDoTableModel(Vector<String> headers, Vector<Vector<String>> data) {
			super(data, headers);
		}

		public boolean isCellEditable(int row, int col) {
			if (col < 1) {
				return false;
			} else {
				return true;
			}
		}
	}
}
