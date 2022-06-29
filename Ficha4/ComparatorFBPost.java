package com.company;


import java.util.Comparator;

public class ComparatorFBPost implements Comparator<FBPost> {
    public int compare (FBPost f1, FBPost f2) {
        int r;
        int n1 = f1.getComentarios().size();
        int n2 = f2.getComentarios().size();

        if (n1 == n2) r = 0;
        else if (n1 < n2) r = 1;
        else r = -1;
        return r;
    }
}
