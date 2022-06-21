package Loesungen.Kapitel16;

import java.util.*;

// Aufgabe 47
public class Customer {
    private int customerNo;
    private String name;
    private double budget;
    private List<Article> articles;

    public Customer(int customerNo, String name, double budget) {
        this.customerNo = customerNo;
        this.name = name;
        this.budget = budget;
        this.articles = new ArrayList<>();
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public double calculateTotalPrice() {
        double sum = 0;
        for (Article a : articles) {
            sum += a.getPreis();
        }
        return sum;
    }

    public boolean payArticles() {
        if (budget >= calculateTotalPrice()) {
            budget -= calculateTotalPrice();
            articles.clear();
            return true;
        } else {
            return false;
        }
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}