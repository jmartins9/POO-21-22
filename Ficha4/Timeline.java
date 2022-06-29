package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


public class Timeline {

    private List<FBPost> posts;

    public Timeline(List<FBPost> posts) {
        List<FBPost> copia = new ArrayList<>();
        for(FBPost f : posts)
            copia.add(f.clone());
        this.posts = copia;
    }

    public Timeline(){
        this.posts = new ArrayList<>();
    }

    public Timeline(Timeline t){
        this.posts = t.getPosts();
    }

    public List<FBPost> getPosts() {
        List<FBPost> copia = new ArrayList<>();
        for(FBPost f : this.posts)
            copia.add(f.clone());
        return copia;
    }

    public void setPosts(List<FBPost> posts) {
        List<FBPost> copia = new ArrayList<>();
        for(FBPost f : posts)
            copia.add(f.clone());
        this.posts = copia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Timeline { ");
        sb.append("posts = ").append(this.posts.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeline timeline = (Timeline) o;
        return getPosts().equals(timeline.getPosts());
    }

    public Timeline clone (Timeline t) {
        return new Timeline(this);
    }

    public void addPost (FBPost f) {
        this.posts.add(f);
    }

    public int nrPosts(String user) {
        int count=0;
        for(FBPost f : this.posts) {
            if (f.getNome().compareTo(user)==0) {
                count++;
            }
        }
        return count;
    }

    public List<FBPost> postsOf(String user) {
        int count=0;
        List<FBPost> filt = new ArrayList<>();
        for(FBPost f : this.posts) {
            if (f.getNome().compareTo(user)==0) {
                filt.add(f.clone());
            }
        }
        return filt;
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim) {
        int count=0;
        List<FBPost> filt = new ArrayList<>();
        for(FBPost f : this.posts) {
            if (f.getNome().compareTo(user)==0 && inicio.compareTo(f.getInstanteDeCriacao())<=0 && fim.compareTo(f.getInstanteDeCriacao())>=0) {
                filt.add(f.clone());
            }
        }
        return filt;
    }

    public FBPost getPost(int id) {
        Iterator<FBPost> it = this.posts.iterator();
        boolean b = false;
        FBPost r = null;
        while (it.hasNext() && !b) {
            FBPost f = it.next();
            if (f.getId() == id) {
                b=true;
                r = f.clone();
            }
        }
        return r;
    }

    public void comment(FBPost post, String comentario) {
        for(FBPost f : this.posts) {
            if (f.equals(post)) {
               f.addComment(comentario);
            }
        }
    }

    public void comment(int postid, String comentario) {
        for(FBPost f : this.posts) {
            if (f.getId()==postid) {
                f.addComment(comentario);
            }
        }
    }

    public void like(FBPost post) {
        for(FBPost f : this.posts) {
            if (f.equals(post)) {
                f.like();
            }
        }
    }

    public void like(int postid) {
        for(FBPost f : this.posts) {
            if (f.getId()==postid) {
                f.like();
            }
        }
    }

    public List<Integer> top5Comments() {
        TreeSet<FBPost> lista = new TreeSet<>(new ComparatorFBPost());
        Iterator<FBPost> it = this.posts.iterator();
        while (it.hasNext()) {
            FBPost f = it.next();
            lista.add(f.clone());
        }

        int i = 0;
        List<Integer> resultado = new ArrayList<>();
        Iterator<FBPost> it1 = lista.iterator();
        while (it1.hasNext() && i<5) {
            FBPost f = it1.next();
            resultado.add(f.getId());
            i++;
        }
        return resultado;
    }

}
