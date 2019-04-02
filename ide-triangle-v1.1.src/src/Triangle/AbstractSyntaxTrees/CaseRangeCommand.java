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
public class CaseRangeCommand extends Command{
    public CaseRangeCommand (Expression iAST,Expression i2AST,SourcePosition thePosition) {
        super (thePosition);
        I = iAST;
        I2=i2AST;
   
      }

      public Object visit(Visitor v, Object o) {
        return v.visitCaseRangeCommand(this, o);
      }

      public Expression I;
      public Expression I2;
    
}
