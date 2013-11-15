package datastructs.graphs;

/*
 * sin título.java
 *
 * Copyright 2013 Daniel Jenkins <jeukel@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


import java.util.ArrayList;
public class Node{
    
    private Object dato;
    private ArrayList<Node> nodo;
    public boolean visitado = false;

    public Node(){
        this(new Object());
    }
    public Node(Object dato){
        this.dato = dato;
        nodo = new ArrayList<Node>();
    }
    public void setDato(Object dato){
        this.dato = dato;
    }
    public Object getDato(){
        return this.dato;
    }
    public void setNodo(Node nodo){
        this.nodo.add(nodo);
    }
    public ArrayList<Node> getHijos(){
        return nodo;
    }
}
