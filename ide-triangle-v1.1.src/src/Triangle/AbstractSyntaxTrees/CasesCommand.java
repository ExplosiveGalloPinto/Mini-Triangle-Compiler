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

public class CasesCommand extends Command{
    public CasesCommand (Command cdAST,Command edAST,SourcePosition thePosition) {
        super (thePosition);
        cd = cdAST;
        e=edAST;
   
      }

      public Object visit(Visitor v, Object o) {
        return v.visitCasesCommand(this, o);
      }

      public Command cd;
      public Command e;
    
}
