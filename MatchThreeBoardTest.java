/*
 * MatchThreeBoardTest.java
 * Copyright (c) 2017 Markus Himmel
 * This file is distributed under the terms of the MIT license.
 */

package edu.kit.informatik.matchthree.tests;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.kit.informatik.matchthree.MatchThreeBoard;
import edu.kit.informatik.matchthree.framework.Position;
import edu.kit.informatik.matchthree.framework.Token;
import edu.kit.informatik.matchthree.framework.interfaces.Board;
import edu.kit.informatik.matchthree.framework.exceptions.BoardDimensionException;
import edu.kit.informatik.matchthree.framework.exceptions.TokenStringParseException;

public class MatchThreeBoardTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void basicTest() {
        Board board = new MatchThreeBoard(Token.set("AB"), 2, 3);

        assertEquals(2, board.getColumnCount());
        assertEquals(3, board.getRowCount());
        assertEquals(Token.set("AB"), board.getAllValidTokens());
    }

    @Test
    public void invalidBoardDimensions1Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), 1, 2);
    }

    @Test
    public void invalidBoardDimensions2Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), 2, 1);
    }

    @Test
    public void invalidBoardDimensions3Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), 2, 0);
    }

    @Test
    public void invalidBoardDimensions4Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), 0, 2);
    }

    @Test
    public void invalidBoardDimensions5Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), 0, 0);
    }

    @Test
    public void invalidBoardDimensions6Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), -1, 2);
    }

    @Test
    public void invalidBoardDimensions7Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), 2, -1);
    }

    @Test
    public void invalidBoardDimensions8Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), -1, -1);
    }

    @Test
    public void invalidBoardDimensions9Test()
    {
        exception.expect(BoardDimensionException.class);
        new MatchThreeBoard(Token.set("AB"), -2147483648, -2147483648);
    }

    @Test
    public void nullTokens1Test()
    {
        exception.expect(IllegalArgumentException.class);
        new MatchThreeBoard(null, 2, 2);
    }

    @Test
    public void nullTokens2Test()
    {
        exception.expect(IllegalArgumentException.class);
        new MatchThreeBoard(null, "  ;  ");
    }

    @Test
    public void invalidTokens1Test()
    {
        exception.expect(IllegalArgumentException.class);
        new MatchThreeBoard(Token.set(""), 2, 2);
    }

    @Test
    public void invalidTokens2Test()
    {
        exception.expect(IllegalArgumentException.class);
        new MatchThreeBoard(Token.set("a"), 2, 2);
    }

    @Test
    public void invalidTokens3Test()
    {
        exception.expect(IllegalArgumentException.class);
        new MatchThreeBoard(Token.set("aa"), 2, 2);
    }

    @Ignore("The references to the tokens alone take up 36.9 Exabytes. Reenable if the game need to be webscale")
    @Test
    public void hugeDimensionTest()
    {
        new MatchThreeBoard(Token.set("ab"), 2147483647, 2147483647);
    }

    @Test
    public void nullTokenStringTest()
    {
        exception.expect(IllegalArgumentException.class);
        new MatchThreeBoard(Token.set("aa"), null);
    }

    @Test
    public void invalidTokenString1Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "");
    }

    @Test
    public void invalidTokenString2Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), ";");
    }

    @Test
    public void invalidTokenString3Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "a");
    }

    @Test
    public void invalidTokenString4Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "a;a");
    }

    @Test
    public void invalidTokenString5Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aa;a");
    }

    @Test
    public void invalidTokenString6Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aa;aaa");
    }

    @Test
    public void invalidTokenString7Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aa;;aa");
    }

    @Test
    public void invalidTokenString8Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), ";aa;aa");
    }

    @Test
    public void invalidTokenString9Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aa;aa;");
    }

    @Test
    public void invalidTokenString10Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aaaaaaaaaaaaaaa");
    }

    @Test
    public void invalidTokenString11Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "a;a;a;a;a;a;a;a;a;a;a");
    }

    @Test
    public void invalidTokenString12Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aaa;aaa;aaaa;aa;aaa");
    }

    @Test
    public void invalidTokenString13Test()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "aaa;aaa;aa;aaaa;aaa");
    }

    @Test
    public void invalidTokenInTokenStringTest()
    {
        exception.expect(TokenStringParseException.class);
        new MatchThreeBoard(Token.set("ab"), "ab;ca");
    }

    @Test
    public void tokenStringMirrorTest()
    {
        String[] strings = new String[]
        {
            "  ;  ",
            "aa;aa",
            "ab;ab",
            "aaa;aaa",
            "aa;aa;aa",
            "ab;ba",
            "aaa;aab;aba;abb;baa;bab;bba;bbb"
        };

        for (String string : strings)
        {
            assertEquals(string,
                new MatchThreeBoard(Token.set("ab"), string).toTokenString());
        }
    }

    @Test
    public void inferDimensionsTest()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), "    ;    ;    ");

        assertEquals(3, board.getRowCount());
        assertEquals(4, board.getColumnCount());
    }

    @Test
    public void createEmptyBoardTest()
    {
        assertEquals("    ;    ;    ",
            new MatchThreeBoard(Token.set("ab"), 4, 3).toTokenString());
    }

    @Test
    public void changeToken1Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 3);
        assertEquals("    ;    ;    ", board.toTokenString());
        board.setTokenAt(Position.at(0, 0), new Token("a"));
        assertEquals("a   ;    ;    ", board.toTokenString());
        board.setTokenAt(Position.at(1, 0), new Token("b"));
        assertEquals("ab  ;    ;    ", board.toTokenString());
        board.setTokenAt(Position.at(3, 2), new Token("a"));
        assertEquals("ab  ;    ;   a", board.toTokenString());
        board.setTokenAt(Position.at(0, 0), null);
        assertEquals(" b  ;    ;   a", board.toTokenString());
    }

    @Test
    public void changeToken2Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("abcde"), "ab; e;da");
        assertEquals("ab; e;da", board.toTokenString());
        board.setTokenAt(Position.at(0, 0), null);
        assertEquals(" b; e;da", board.toTokenString());
        board.setTokenAt(Position.at(0, 1), new Token("c"));
        assertEquals(" b;ce;da", board.toTokenString());
        board.setTokenAt(Position.at(0, 1), new Token("a"));
        assertEquals(" b;ae;da", board.toTokenString());
    }

    @Test
    public void getAllValidTokensTest()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 2, 2);
        Set<Token> valid = board.getAllValidTokens();

        assertEquals(2, valid.size());
        assertTrue(valid.contains(new Token('a')));
        assertTrue(valid.contains(new Token('b')));
    }

    @Test
    public void validTokensDoNotAllowTampering1Test()
    {
        HashSet<Token> myTokens = new HashSet<>();

        myTokens.add(new Token("a"));
        myTokens.add(new Token("b"));

        MatchThreeBoard board = new MatchThreeBoard(myTokens, 2, 2);

        myTokens.add(new Token("c"));

        Set<Token> valid = board.getAllValidTokens();

        assertEquals(2, valid.size());
        assertTrue(valid.contains(new Token('a')));
        assertTrue(valid.contains(new Token('b')));
        assertFalse(valid.contains(new Token('c')));
    }

    @Test
    public void validTokensDoNotAllowTampering2Test()
    {
        HashSet<Token> myTokens = new HashSet<>();

        myTokens.add(new Token("a"));
        myTokens.add(new Token("b"));

        MatchThreeBoard board = new MatchThreeBoard(myTokens, 2, 2);

        myTokens.add(new Token("c"));

        exception.expect(IllegalArgumentException.class);
        board.setTokenAt(Position.at(0, 0), new Token("c"));
    }

    @Test
    public void validTokensDoNotAllowTampering3Test()
    {
        HashSet<Token> myTokens = new HashSet<>();

        myTokens.add(new Token("a"));
        myTokens.add(new Token("b"));

        MatchThreeBoard board = new MatchThreeBoard(myTokens, 2, 2);

        Set<Token> valid = board.getAllValidTokens();

        try
        {
            valid.add(new Token("c"));
        }
        catch (Exception ex)
        {
            // This will either throw or not, we don't care whether it does
            // as long as the underlying set is not modified.
        }

        assertEquals(2, valid.size());
        assertFalse(valid.contains(new Token("c")));

        valid = board.getAllValidTokens();
        assertEquals(2, valid.size());
        assertFalse(valid.contains(new Token("c")));

        exception.expect(IllegalArgumentException.class);
        board.setTokenAt(Position.at(0, 0), new Token("c"));
    }

    @Test
    public void setTokenAtOutOfBounds1Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(2, 4), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds2Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(4, 2), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds3Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(4, 4), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds4Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(2, -1), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds5Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(-1, 2), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds6Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(-1, -1), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds7Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(2147483647, 2147483647), new Token("a"));
    }

    @Test
    public void setTokenAtOutOfBounds8Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.setTokenAt(Position.at(-2147483648, -2147483648), new Token("a"));
    }

    @Test
    public void getTokenAtOutOfBounds1Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(2, 4));
    }

    @Test
    public void getTokenAtOutOfBounds2Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(4, 2));
    }

    @Test
    public void getTokenAtOutOfBounds3Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(4, 4));
    }

    @Test
    public void getTokenAtOutOfBounds4Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(2, -1));
    }

    @Test
    public void getTokenAtOutOfBounds5Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(-1, 2));
    }

    @Test
    public void getTokenAtOutOfBounds6Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(-1, -1));
    }

    @Test
    public void getTokenAtOutOfBounds7Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(2147483647, 2147483647));
    }

    @Test
    public void getTokenAtOutOfBounds8Test()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 4);

        exception.expect(BoardDimensionException.class);
        board.getTokenAt(Position.at(-2147483648, -2147483648));
    }

    @Test
    public void getTokenTest()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("ab"), 4, 5);

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                assertNull(board.getTokenAt(Position.at(i, j)));
            }
        }

        board.setTokenAt(Position.at(2, 3), new Token('a'));
        assertNull(board.getTokenAt(Position.at(3, 2)));
        assertEquals(new Token("a"), board.getTokenAt(Position.at(2, 3)));

        board = new MatchThreeBoard(Token.set("cdef"), "cdd ;dfdc;ccde");
        assertNull(board.getTokenAt(Position.at(3, 0)));
        assertEquals(new Token('e'), board.getTokenAt(Position.at(3, 2)));
        board.setTokenAt(Position.at(3, 0), new Token("c"));
        assertEquals(new Token('c'), board.getTokenAt(Position.at(3, 0)));
        assertEquals("cddc;dfdc;ccde", board.toTokenString());
    }

    @Test
    public void remoteTokensRollback()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("abc"), " ab;abc");
        LinkedHashSet<Position> pos = new LinkedHashSet<>();
        pos.add(new Position(0, 0));
        pos.add(new Position(0, 1));
        pos.add(new Position(2, 1));
        pos.add(null);
        pos.add(new Position(2, 2));

        try
        {
            board.removeTokensAt(pos);
            fail("This should have thrown");
        }
        catch (IllegalArgumentException ex)
        {
        }

        assertEquals(" ab;abc", board.toTokenString());
    }
}


// vim: set expandtab:
