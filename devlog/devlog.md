# SAGE

_devlog_

## Week of June 25 2017
#### WEEK GOALS
* Expand the capabilities of the Reasoner
* Create test cases for Reasoner
* Research ways to incorporate graph algorithms into RDF

#### OVERVIEW
Following the creation of the initial prototype, the second week will be a continuation on the same component, to get it ready for integration with the others. The existence of the Factory & Interface are promising for this integration.

#### NOTES

**On Implementing Graph Algorithms**
I took a look at what is allowed through Jena's Graph class and there doesn't seem to be a way to export the graph into a form that is extendable. I will look into the code, and on the event that there truly is nothing there, I will have to make some kind of extension to the graph package.

The idea is to convert the RDF into a traversible graph *efficiently*. The only reason I'm using RDF is the fact that it can streamline some of these processes better than other data formats.

**On Clarity with Development Schedule**
So far I've changed the schedule at the previous entry twice, proclaiming that some of the components that I had scheduled were no longer useful or necessary. That is a reasonable turn of events, as the entire process is still at a stage where the result is not known and the tools may not be enough to complete the test (see previous).

**Steam Condenser**
Just found a useful library that directly queries the Steam API and will be useful integrated instead of written outside of the application. This solves many problems at once! It is also freely extensible, so I will not have problems updating and recompiling it into my own version.

**Schedule**

| Task              | Deadline      | Status        |
| ----------------- |---------------|---------------|
| Initial Prototype | June 23, 2017 | Completed     |
| Reasoner Ruleset  | July 7, 2017  | In Progess    |
| Inference Engine  | July 14, 2017 | Not Started   |
| Input / Output    | July 21, 2017 | Not Started   |

#### CONCLUSIONS


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
        Output (RDF-Turtle) & (RDF-XML)

**Schedule**

| Task              | Deadline      | Status        |
| ----------------- |---------------|---------------|
| Initial Prototype | June 23, 2017 | Completed     |
| Reasoner Ruleset  | July 7, 2017  | Not Started   |
| Inference Engine  | July 14, 2017 | Not Started   |
| Input / Output    | July 21, 2017 | Not Started   |

#### CONCLUSIONS

This week has been successful. The prototype is now completed. In the coming week I will be making a full component for the reasoner, keeping in mind some important takeaways from building the component:

* In order to create loosely-tied components, I had to create wrapper classes for the main OntClasses.
* There is possibly no noeed for the inference engine scheduled, as the OntModel class within Jena handles that.
* There will be a need for a way to dynamically handle RAM, given the large amounts of data this is designed for.

These will be taken into consideration for next week's updated schedule.
