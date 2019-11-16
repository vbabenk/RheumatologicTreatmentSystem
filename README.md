# RheumatologicTreatmentSystem
System of predicting the course of disease in rheumatologic patients.

There were 3 groups of rheumatological patients: with polyarthritis, with oligoarthritis and with enthesitis arthritis. For each group classification models were built using group method of data handling.

The task was to build an algorithm for finding treatment strategy to avoid articular and extraarticular injuries after

### Group method of data handling (GMDH)
- GMDH was used for building classification models. 
- Models were built in <a href="https://gmdhsoftware.com/docs/">**GMDH Shell DS**</a> software.
- Data sample was divided into training (<b>85%</b>) and test (<b>15%</b>) samples.
- Classication models were built for 3 groups of patients.
- In total, <b>6 models</b> were built.
- Accuracy of models on test sample varies from <b>77.6%</b> to <b>97%</b>.
- Sensitivity on test sample varies from <b>0.769</b> to <b>1</b>.
- Specificity on test sample varies from <b>0.85</b> to <b>1</b>.
