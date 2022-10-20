package src;

import java.io.*;
import java.util.ArrayList;

/**
 * Tracks the user's assignments for their courses and allows them to
 * add, remove, and modify courses and assignments
 *
 * @since October 20, 2022
 */
public class App {
    private static final File COURSES_FILE = new File("HomeworkTracker/data/courses.txt");
    private static ArrayList<Course> courses;

    public static void main(String[] args) {
        try {
            coursesFromFile();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("There was an issue loading your courses.");
        } catch (IOException ioe) {
            System.out.println("There was an issue reading your courses.");
        }

        System.out.println("Welcome to Homework Tracker.");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1: View assignments");
            System.out.println("2: Add an assignment");
            System.out.println("3: Remove an assignment");
            System.out.println("4: Modify an assignment");
            System.out.println("5: Add a course");
            System.out.println("6: Remove a course");
        }
    }

    /**
     * Reads in courses from a file
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void coursesFromFile() throws IOException, ClassNotFoundException {
        courses = new ArrayList<>();

        if (!COURSES_FILE.exists()) {
            return;
        }
        ObjectInputStream objectInStream = new ObjectInputStream(new FileInputStream(COURSES_FILE));

        Course course;
        while ((course = (Course) objectInStream.readObject()) != null) {
            courses.add(course);
        }
    }

    /**
     * Writes courses to a file
     *
     * @throws IOException
     */
    private static void coursesToFile() throws IOException {
        if (!COURSES_FILE.exists()) {
            COURSES_FILE.createNewFile();
        }
        ObjectOutputStream objectOutStream = new ObjectOutputStream(new FileOutputStream(COURSES_FILE));

        for (Course course: courses) {
            objectOutStream.writeObject(course);
        }
    }
}