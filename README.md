#Voting Interface Project

Simple interactive JavaFX based GUI project for CSC 34400 GUI Application Design. Made basic design decisions for a tabbed GUI that displays a vote count.

#Problem Statement

-[x] Enter in the name of a new candidate.
-[x] Delete an existing candidate by selecting them from a list of candidates.
-[x] View the current proportions of votes each candidate has received relative to each other in both a bar chart format and a pie chart format.
-[x] Vote for an existing candidate.
-[x] Reset the system so that there are no candidates.
-[x] Quit using the program.

The following is a minimal list of user interface functionality that you must add:

The <b>Add New Candidate</b> option should allow the user to type in a new candidate name and add that name into the bar chart and pie chart areas. This should be accomplished by being able to type into a text field in the main area (not through a separate pop-up box). A new candidate should have 1 vote by default.
Should the name already be a currently existing candidate, the user interface should not add a second version of the candidate. Instead, the program should pop up a dialog box that alerts the user as to the fact that the candidate already exists. Note that the candidate's vote count should NOT be reset to 0 as in the first project!

The <b>Current Vote Status</b> should be displayed using one of two options, each in its own tab. One tab should hold a pie chart version of the current vote status, while another tab should hold a bar chart version of the current status. Note that, as with all tabbed environments, only one of these two options should be visible at any one point in time. You should also make sure to keep both charts in sync with the current vote counts. At any point in time, both charts should reflect the same (current) status of the election. Also, take care when labeling components should you choose to leave them labeled - for example, it makes little sense to imply that a candidate could receive 2.5 votes.

After at least one candidate has been added (which means the candidate has at least one vote), you should be able to click on that candidate's area in either the bar chart or the pie chart area to vote for them. Make sure that a <b>click in one chart is reflected in both charts.</b>

The <b>Delete Candidate Option</b> should allow the user to select an existing candidate from a list of candidates and remove that candidate. Don't forget to actually remove the associated bar plot and pie chart components, and make sure that the candidate is removed from the list of candidates that could be deleted !

The <b>Reset Option</b>, when clicked, should remove all of the candidates. Make sure that both charts no longer have any candidates in them, and that the list of candidates that could be deleted would now be empty.

The <b>Quit Option</b>, when clicked, should quit the program. Subsequent runs of the program should start freshly, with no candidates in the list of candidates.

<p align="center">
  <h3>Pie Chart view</h3>
  <img src="/example1.PNG" />
  
  <br>
  
  <h3>Bar Chart view</h3>
  <img src="/example2.PNG" />
  
  <br>
  
  <h3>Candidates can be deleted after addition</h3>
  <img src="/example3.PNG" />
</p>
