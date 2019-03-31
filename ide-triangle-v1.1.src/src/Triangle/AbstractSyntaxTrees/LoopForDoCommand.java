/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

/**
 *
 * @author Ale
 */
import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopForDoCommand extends Command {
    public LoopForDoCommand (Identifier iAST, Expression eAST1, Expression eAST2, Command cAST, SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
        E1 = eAST1;
        E2 = eAST2;
        C = cAST;
      }

      public Object visit(Visitor v, Object o) {
        return v.visitLoopForDoCommand(this, o);
      }

      public Identifier I;
      public Expression E1,E2;
      public Command C;
}

