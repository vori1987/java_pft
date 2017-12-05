$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bdd/groups.feature");
formatter.feature({
  "line": 1,
  "name": "Groups",
  "description": "",
  "id": "groups",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Group creation",
  "description": "",
  "id": "groups;group-creation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I create a new group with name \u003cname\u003e, header \u003cheader\u003e and footer \u003cfooter\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the new set of groups is equal to the old set with the added group",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "groups;group-creation;",
  "rows": [
    {
      "cells": [
        "name",
        "header",
        "footer"
      ],
      "line": 9,
      "id": "groups;group-creation;;1"
    },
    {
      "cells": [
        "test_name",
        "test_header",
        "test_footer"
      ],
      "line": 10,
      "id": "groups;group-creation;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 6764566710,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Group creation",
  "description": "",
  "id": "groups;group-creation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "a set of groups",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I create a new group with name test_name, header test_header and footer test_footer",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the new set of groups is equal to the old set with the added group",
  "keyword": "Then "
});
formatter.match({
  "location": "GroupStepDefinitions.loadGroups()"
});
formatter.result({
  "duration": 514798168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test_name",
      "offset": 31
    },
    {
      "val": "test_header",
      "offset": 49
    },
    {
      "val": "test_footer",
      "offset": 72
    }
  ],
  "location": "GroupStepDefinitions.createGroup(String,String,String)"
});
formatter.result({
  "duration": 1388488527,
  "status": "passed"
});
formatter.match({
  "location": "GroupStepDefinitions.verifyGroupCreated()"
});
formatter.result({
  "duration": 19974807,
  "status": "passed"
});
formatter.after({
  "duration": 623252743,
  "status": "passed"
});
});