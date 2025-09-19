package app.code.verse.adapter.in.builder;

import app.code.verse.adapter.in.validators.PolicyValidator;
import app.code.verse.domain.model.Policy;

import java.time.LocalDate;

public class PolicyBuilder {
    private PolicyValidator policyValidator;
    public Policy build(String companyName, String policyNumber, LocalDate policyValidity) throws Exception {
        Policy policy = new Policy();
        policy.setCompanyName(policyValidator.policyNameValidator(companyName));
        policy.setPolicyNumber(policyValidator.policyNumberValidator(policyNumber));
        policy.setActive(true);
        policy.setExpirationDate(policyValidator.policyDateValidator(policyValidity));
        return policy;
    }
}
