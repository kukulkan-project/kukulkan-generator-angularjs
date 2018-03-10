package mx.infotec.dads.kukulkan.generator.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Rule Context
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public class RuleContext {

    private List<Rule> rules;

    public RuleContext(List<Rule> rules) {
        Objects.requireNonNull(rules);
        this.rules = rules;
    }

    public List<Rule> getAllSingularRules() {
        return rules.parallelStream().filter(rule -> rule.getRuleType().getName().equals("singular"))
                .collect(Collectors.toList());
    }
}
