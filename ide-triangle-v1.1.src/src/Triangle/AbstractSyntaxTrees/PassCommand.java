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
public class PassCommand extends Command{
    public PassCommand(SourcePosition thePosition) {
    super (thePosition);
  }

  public Object visit(Visitor v, Object o) {
    return v.visitPassCommand(this, o);
  }
    
}
