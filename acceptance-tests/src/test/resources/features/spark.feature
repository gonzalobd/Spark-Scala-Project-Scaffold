@ActivateSegment
Feature: Feature for ${processName}

  Scenario Outline: Test Amortizaciones ETL
    Given a config file <file>
    When execute in spark
    Then should produce an output in <output>

    Examples:
      | file                | output                 |
      | application.conf         | true                   |
