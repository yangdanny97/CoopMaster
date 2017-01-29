# CoopMaster
Android App for Cornell Animal Health Hackathon - data recording and visualization for owners of small backyard poultry flocks


Product Overview: A mobile app that tracks and displays information about backyard chicken flocks, so that the owner can be more aware of any health or wellbeing concerns.


Features:


Eggs per day- records the number of eggs collected and plot on a graph to show any trends over time in egg production, which is a possible indicator of stress/calcium deficiency.


Food/Water consumption- planned hardware sensor that monitors food and water levels inside the henhouse, to see if the chickens are eating and drinking regularly. Any change in eating and drinking habits could be indicative of stress or health problems. The information can be entered manually daily (volume of water remaining, weight of feed remaining) or from a set of sensors-
The water sensor will be based on water pressure in the container, while the feed sensor will be based on weight.


Roosting times- planned hardware sensor that monitors roosting times for chickens, to see if there are any disturbances at night. There are several ideas for this sensor that require further testing- motion sensing (logging any activity at night) or infrared (detects and logs when chickens are sitting in their roosting places).


What we implemented:


We implemented a data entry and storage system, as well as a system that displays the data in a graph. The manual data entry and display for egg production, remaining chicken feed, and water levels are fully implemented, as well as a demonstration of the other components using hardcoded data (since we don’t have a chicken flock to collect data from). The app is available in both ios and Android so it is accessible to all chicken owners.


Plans for the future:


We need to do more testing on actual chickens to determine how to best build the sensors, and implement a data collection system from the sensors. We didn’t implement those features during the hackathon because we lack actual chickens to experiment on.
