/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvauspeli.notUi;

import arvauspeli.logics.Score;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author hveikka
 */
public class ScoreTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;

    @Test
    public void getScores() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");

        Score.writeScore("testfile_users.txt", "Matti", 9);
        assertEquals("Matti: 9" + "\n", Score.getScores("testfile_users.txt", 1));
        userFile.delete();
        testFolder.delete();
    }

    @After
    public void tearDown() {
        userFile.delete();
        testFolder.delete();

    }

}
