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
public class CaseLiteralsCommand extends Command{
    public CaseLiteralsCommand (Command cdAST,Command cd2AST,SourcePosition thePosition) {
        super (thePosition);
        cd = cdAST;
        cd2=cd2AST;
   
      }

      public Object visit(Visitor v, Object o) {
        return v.visitCaseLiteralsCommand(this, o);
      }

      public Command cd;
      public Command cd2;
    
}