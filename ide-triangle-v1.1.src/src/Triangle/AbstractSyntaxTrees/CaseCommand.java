/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Ale
 */

public class CaseCommand extends Command{
    public CaseCommand (Command clAST,Command cAST,SourcePosition thePosition) {
        super (thePosition);
        cl = clAST;
        c=cAST;
   
      }

      public Object visit(Visitor v, Object o) {
        return v.visitCaseCommand(this, o);
      }

      public Command cl;
      public Command c;
    
}
