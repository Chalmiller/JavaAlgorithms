/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

	
public class ExpressionTree extends BinaryTree<String> {
    public ExpressionTree() {
    } // end default constructor
    
    public ExpressionTree(String data) {
		super(data);
    } // end default constructor
    
    public double evaluate() {
		return evaluate(root);
    } // end evaluate
    
    private double evaluate(BinaryNode<String> rootNode) {
		double result;
	
		if (rootNode == null)
			result = 0;
		else if (rootNode.isLeaf()) {
			String variable = rootNode.getData();
			result = getValueOf(variable);
		}
		else {
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		} // end if

		return result;
    } // end evaluate
    
    private double getValueOf(String variable) { // strings allow multicharacter variables
	
		double result = 0;
	
		if (variable.equals("a"))
			result = 1;
		else if (variable.equals("b"))
			result = 2;
		else if (variable.equals("c"))
			result = 3;
		else if (variable.equals("d"))
			result = 4;
		else if (variable.equals("e"))
			result = 5;
	
		return result;
   } // end getValueOf

   private double compute(String operator, double firstOperand, double secondOperand)
   {
      double result = 0;
      
      if (operator.equals("+"))
	  	result = firstOperand + secondOperand;
      else if (operator.equals("-"))
	  	result = firstOperand - secondOperand;
      else if (operator.equals("*"))
	  	result = firstOperand * secondOperand;
      else if (operator.equals("/"))
	  	result = firstOperand / secondOperand; 
      return result;
   } // end compute
   
   public ExpressionTree(String infix) {
       return formTree(infix);
   }
   
   private ExpressionTreeInterface formTree(String expr, int first, int last) {
       BinaryTree<String> expression = new ExpressionTree(expr);
       
       if (expression.getRootData() != null) {
           formTree(expression, expression.getLeft(), expression.getRight())
       }
   }
   
} // end ExpressionTree
