package com.zzm.cz.meituan.first;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan
 * @Author: zzm
 * @CreateTime: 2024-03-09  11:51
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n,q;
        m=in.nextInt();
        n=in.nextInt();
        q=in.nextInt();




    }

    static class Person{
        private String name;
        private List<Person> friends;

        public Person(String name){
            this.name=name;
            this.friends=new ArrayList<>();

        }

        public String getName(){
            return  name;

        }

        public List<Person> getFiends(){
            return friends;
        }

        public void addFriend(Person person){
            friends.add(person);
        }
    }

    static class Graph{
        private Map<String ,Person> graph;

        public Graph(){
            graph=new HashMap<>();
        }


        public void addRelation(Person p1,Person p2){
            graph.putIfAbsent(p1.getName(), p1);
            graph.get(p1.getName()).addFriend(p2);

            graph.putIfAbsent(p2.getName(),p2);
            graph.get(p2.getName()).addFriend(p1);
        }

        public Person getPerson(String name){
            return graph.get(name);
        }

        public boolean canMeet(Person p1,Person p2){
            Set<Person> visited=new HashSet<>();
            dfs(p1,p2,visited);
            return visited.contains(p2);
        }

        private void dfs(Person p1, Person p2, Set<Person> visited) {
            visited.add(p1);
            for(Person friend:p1.getFiends()){
                if(friend!=p2&&visited.contains(friend)){
                    dfs(friend,p2,visited);
                }
            }
        }

    }
}
