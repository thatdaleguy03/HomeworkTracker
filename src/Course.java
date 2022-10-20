package src;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    String title;
    ArrayList<Assignment> assignments;
}