/*
 * MoveFactoryImplmentationTest.java
 * Copyright (c) 2017 Markus Himmel
 * This file is distributed under the terms of the MIT license.
 */
package edu.kit.informatik.matchthree.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.kit.informatik.matchthree.MatchThreeBoard;
import edu.kit.informatik.matchthree.MoveFactoryImplementation;
import edu.kit.informatik.matchthree.framework.Position;
import edu.kit.informatik.matchthree.framework.Token;
import edu.kit.informatik.matchthree.framework.interfaces.Move;

public class MoveFactoryImplementationTest
{
    @Test
    public void BasicFunctionalityTest()
    {
        MatchThreeBoard board = new MatchThreeBoard(Token.set("abcd"),
            "abcd;badd;c ab;daaa");

        MoveFactoryImplementation fact = new MoveFactoryImplementation();
        Move theMove = fact.flipRight(Position.at(1, 0));
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("acbd;badd;c ab;daaa", board.toTokenString());

        theMove = fact.flipDown(Position.at(3, 1));
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("acbd;badb;c ad;daaa", board.toTokenString());

        theMove = fact.rotateSquareClockwise(Position.at(1, 0));
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("aacd;bdbb;c ad;daaa", board.toTokenString());

        theMove = fact.rotateColumnDown(0);
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("dacd;adbb;b ad;caaa", board.toTokenString());

        theMove = fact.rotateRowRight(2);
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("dacd;adbb;db a;caaa", board.toTokenString());

        theMove = fact.rotateSquareClockwise(Position.at(0, 2)).reverse();
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("dacd;adbb;ba a;dcaa", board.toTokenString());

        theMove = fact.rotateColumnDown(2).reverse();
        assertTrue(theMove.canBeApplied(board));
        theMove.apply(board);
        assertEquals("dabd;ad b;baaa;dcca", board.toTokenString());
    }
}

// vim: set expandtab:
