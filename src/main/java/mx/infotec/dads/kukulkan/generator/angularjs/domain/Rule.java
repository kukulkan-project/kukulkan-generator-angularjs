/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2016 Daniel Cortes Pichardo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.kukulkan.generator.angularjs.domain;

import java.io.Serializable;

/**
 * The Rule Class.
 *
 * @author Daniel Cortes Pichardo
 */
public class Rule implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The expression. */
    private String expression;

    /** The replacement. */
    private String replacement;

    /** The rule type. */
    private RuleType ruleType;

    /**
     * Gets the expression.
     *
     * @return the expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets the expression.
     *
     * @param expression
     *            the new expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets the replacement.
     *
     * @return the replacement
     */
    public String getReplacement() {
        return replacement;
    }

    /**
     * Sets the replacement.
     *
     * @param replacement
     *            the new replacement
     */
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    /**
     * Gets the rule type.
     *
     * @return the rule type
     */
    public RuleType getRuleType() {
        return ruleType;
    }

    /**
     * Sets the rule type.
     *
     * @param ruleType
     *            the new rule type
     */
    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

}
