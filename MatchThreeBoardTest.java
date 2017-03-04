package edu.kit.informatik.matchthree.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.kit.informatik.matchthree.MatchThreeBoard;
import edu.kit.informatik.matchthree.framework.Token;
import edu.kit.informatik.matchthree.framework.interfaces.Board;

public class MatchThreeBoardConstructorTest {

    @Test
    public void basicTest() {
        Board board = new MatchThreeBoard(Token.set("AB"), 2, 3);

        assertEquals(2, board.getColumnCount());
        assertEquals(3, board.getRowCount());
        assertEquals(Token.set("AB"), board.getAllValidTokens());
    }
}

// vim: set expandtab
