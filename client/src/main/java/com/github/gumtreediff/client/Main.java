package com.github.gumtreediff.client;

import com.github.gumtreediff.gen.jsitter.TreeSitterTreeGenerator;
import com.github.gumtreediff.tree.Tree;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("### Hello to Gumtree with Tree Sitter parser ###");
        System.out.println("Please select required option:");
        System.out.println("1. Type keyword 'parse' if you want to parse java code from input.");
        System.out.println("2. Type keyword 'compare' if you want to compare two trees.");
        Scanner scan = new Scanner(System.in);
        String method = scan.nextLine();

        switch (method) {
            case "parse":
                System.out.println("First");
                break;
            case "compare":
                System.out.println("Second");
                break;
            default:
                System.out.println("Wrong method");
                break;
        }

        // arg1: parse arg2: file or string
        // arg1: compare arg2: tree1 arg3: tree2


    }

    public void compareTrees(Tree one, Tree second) {
        // TODO: Implement
    }

    public void parseFile(String filePath) {
        // TODO: Implement
    }

    public void parseString(String data) throws IOException {
         Tree tree = new TreeSitterTreeGenerator().generateFrom().string(data).getRoot();
    }
}
