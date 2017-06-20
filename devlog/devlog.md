#SAGE
_devlog_

## Week of June 18 2017
#### WEEK GOALS
* Gather project requirements
* Prepare model prototype

#### OVERVIEW
The first week of development will be focused on better understanding and defining its purpose, requirements, structure and development schedule. This will week I will also make a rough prototype of the base semantics engine that will eventually create an ontology for the players on Steam.

#### NOTES

**Purpose**
SAGE aims to create a 'living-breathing' ontology of all Steam players that groups them by their gaming behavior. All parties involved benefit from this analysis:

* Steam gains a new way of making recommendations to players- purchasing and non.
* Publishers and business-related parties may see sales increase through targeted advertising.
* Developers may gain insight into the organic communities around their games.
* Players can find each other by their similarity metrics, thus creating a more vibrant community.

**Requirements**
* SEMANTICS ENGINE [SUMMER 2017]
* API SERVICE [FALL 2017]
* SCRAPE / RDF STORE SERVER [FALL 2017]
* RECOMMENDATIONS ALGORITHM [WINTER 2017 -> 2018]

**Structure Of Semantics Engine**

    The purpose of this is to:
        Receive the RAW information in JSON and convert it into rdf triples.
        Make necessary inferences based on the given triple store.
        Return the completed RDF graph, including assertions.

    Components
        Input (JSON)
        Jena Connection
        Reasoner Ruleset
        Inference Engine
        Output (RDF-Turtle) & (RDF-XML)

**Schedule**

| Task              | Deadline      |
| ----------------- |---------------|
| Initial Prototype | June 23, 2017 |
| Reasoner Ruleset  | July 7, 2017  |
| Inference Engine  | July 14, 2017 |
| Input / Output    | July 21, 2017 |

#### CONCLUSIONS
