package Aufgaben.Kapitel5.Example;

public class Tree {
    private int height;
    private String sort;
    private static int cnt = 0;

    public Tree(int height, String sort) throws Exception {
        if (height <= 0) {
            throw new Exception("Height cannot be negative");
        }
        this.height = height;
        this.sort = sort;
        cnt++;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public static int getTreeCount() {
        return cnt;
    }

    public String toString() {
        return "height: " + height + ", sort: " + sort;
    }
}