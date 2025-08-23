/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.util.ArrayList;
import java.util.List;

public class Show {
    private List<Selection> sections = new ArrayList<>();

    public void addSection(Selection section) {
        sections.add(section);
    }

    public List<Selection> getSections() {
        return sections;
    }
}
