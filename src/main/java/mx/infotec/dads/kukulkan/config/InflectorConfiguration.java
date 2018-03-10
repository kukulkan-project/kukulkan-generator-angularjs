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
package mx.infotec.dads.kukulkan.config;

import static mx.infotec.dads.kukulkan.generator.util.EntitiesFactory.createDefaultSingularRuleType;
import static mx.infotec.dads.kukulkan.generator.util.EntitiesFactory.createEsRule;
import static mx.infotec.dads.kukulkan.generator.util.EntitiesFactory.createOsRule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.emory.mathcs.backport.java.util.Collections;
import mx.infotec.dads.kukulkan.generator.util.Rule;
import mx.infotec.dads.kukulkan.generator.util.RuleContext;
import mx.infotec.dads.kukulkan.generator.util.RuleType;
import mx.infotec.dads.kukulkan.metamodel.util.InflectorProcessor;

/**
 * Rule Configuration
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Configuration
public class InflectorConfiguration {

    @Bean
    @SuppressWarnings("unchecked")
    public RuleContext contextConfiguration() {
        List<Rule> rules = new ArrayList<>();
        RuleType singularRuleType = createDefaultSingularRuleType();
        Rule osRule = createOsRule(singularRuleType);
        Rule esRule = createEsRule(singularRuleType);
        rules.add(osRule);
        rules.add(esRule);
        for (Rule item : rules) {
            InflectorProcessor.getInstance().addSingularize(item.getExpression(), item.getReplacement());
        }
        return new RuleContext(Collections.unmodifiableList(rules));
    }
}
