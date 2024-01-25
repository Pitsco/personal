---
title: Team Teach Grading
description: Student Teaching Part 2 + Key Indicators
layout: post
courses: {'csa': {'week': 17}}
categories: ['C4.0']
type: tangibles
---

### David:


Individual/Team engagement rating: .45 of .50 basis (.30 did not participate to .45 instrumental participation)

Rate each other and provide me the average

Logistics with Teacher .50 basis, provide evidence

Lessons posted and comments: 0.18 basis of 0.2

Grading complete and on time 0.18 basis of 0.2

Elements of creativity or success 0.09 basis of 0.1

### Ethan:
Review these elements with Teacher

Individual/Team engagement rating: .45 of .50 basis (.30 did not participate to .45 instrumental participation)

Rate each other and provide me the average
Logistics with Teacher .50 basis, provide evidence
Lessons posted and comments: 0.18 basis of 0.2
Grading complete and on time 0.18 basis of 0.2
Elements of creativity or success 0.09 basis of 0.1

### Alex:
Review these elements with Teacher

Individual/Team engagement rating: .45 of .50 basis (.30 did not participate to .45 instrumental participation)

Rate each other and provide me the average
Logistics with Teacher .50 basis, provide evidence
Lessons posted and comments: 0.18 basis of 0.2
Grading complete and on time 0.18 basis of 0.2
Elements of creativity or success 0.09 basis of 0.1

### Jishnu:
Review these elements with Teacher

Individual/Team engagement rating: .45 of .50 basis (.30 did not participate to .45 instrumental participation)

Rate each other and provide me the average
Logistics with Teacher .50 basis, provide evidence
Lessons posted and comments: 0.18 basis of 0.2
Grading complete and on time 0.18 basis of 0.2
Elements of creativity or success 0.09 basis of 0.1

### Kaiden:
Review these elements with Teacher

Individual/Team engagement rating: .45 of .50 basis (.30 did not participate to .45 instrumental participation)

Rate each other and provide me the average
Logistics with Teacher .50 basis, provide evidence
Lessons posted and comments: 0.18 basis of 0.2
Grading complete and on time 0.18 basis of 0.2
Elements of creativity or success 0.09 basis of 0.1


```Java
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Fantasy Basketball</title>
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <style>
    body {
      background-color: #f2f2f2; /* Light Gray */
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
    }
    table {
      border-collapse: collapse;
      width: 100%;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #333; /* Dark Gray */
      padding: 10px;
      text-align: left;
    }
    th {
      background-color: #666; /* Dark Gray */
      color: white;
    }
    button {
      background-color: #666; /* Dark Gray */
      color: white;
      border: none;
      padding: 8px 12px;
      cursor: pointer;
    }
    button:hover {
      background-color: #444; /* Slightly Darker Gray */
    }
  </style>
</head>
<body>

<!-- NBA Team Table -->
<table id="team-data-table">
  <thead>
    <tr>
      <th>Team</th>
      <th>PPG</th>
      <!-- Add other NBA team statistics headers here -->
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <!-- Data will be dynamically added here -->
  </tbody>
</table>

<!-- Fantasy Team Table -->
<table id="fantasy-team-table">
  <thead>
    <tr>
      <th>Fantasy Team</th>
      <th>Selected NBA Teams</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <!-- Data will be dynamically added here -->
  </tbody>
</table>

<button id="add-team-btn">Add NBA Team</button>
<button id="add-fantasy-team-btn">Create Fantasy Team</button>

<script>
  // Example initial NBA team data
  const initialNBAData = [
    { team: 'Lakers', ppg: 112 /* Add other NBA team statistics here */ },
    { team: 'Warriors', ppg: 120 /* Add other NBA team statistics here */ }
  ];

  // Example initial fantasy team data
  const initialFantasyData = [
    { fantasyTeam: 'Fantasy Lakers', selectedNBATeams: ['Lakers'] },
    { fantasyTeam: 'Fantasy Warriors', selectedNBATeams: ['Warriors'] }
  ];

  function renderNBAData(data) {
    const tableBody = $('#team-data-table tbody');
    tableBody.empty();

    data.forEach(item => {
      const row = `
        <tr>
          <td>${item.team}</td>
          <td>${item.ppg}</td>
          <!-- Add other NBA team statistics cells here -->
          <td>
            <button class="update-btn" data-team="${item.team}">Update</button>
            <button class="delete-btn" data-team="${item.team}">Delete</button>
          </td>
        </tr>
      `;
      tableBody.append(row);
    });
  }

  function renderFantasyData(data) {
    const tableBody = $('#fantasy-team-table tbody');
    tableBody.empty();

    data.forEach(item => {
      const row = `
        <tr>
          <td>${item.fantasyTeam}</td>
          <td>${item.selectedNBATeams.join(', ')}</td>
          <td>
            <button class="update-fantasy-btn" data-fantasy-team="${item.fantasyTeam}">Update</button>
            <button class="delete-fantasy-btn" data-fantasy-team="${item.fantasyTeam}">Delete</button>
          </td>
        </tr>
      `;
      tableBody.append(row);
    });
  }

  function addNBATeam() {
    const newTeam = prompt('Enter the name of the NBA team:');
    // Additional prompts for other NBA team statistics
    // Example: const newPPG = prompt('Enter the Points Per Game:');
    
    const newData = [...initialNBAData, { team: newTeam /*, ppg: newPPG, ... */ }];
    renderNBAData(newData);
  }

  function addFantasyTeam() {
    const newFantasyTeam = prompt('Enter the name of the fantasy team:');
    // Additional prompts for selecting NBA teams for the fantasy team
    // Example: const selectedNBATeams = prompt('Enter the selected NBA teams (comma-separated):').split(',');

    const newFantasyData = [...initialFantasyData, { fantasyTeam: newFantasyTeam /*, selectedNBATeams: selectedNBATeams, ... */ }];
    renderFantasyData(newFantasyData);
  }

  $('#add-team-btn').on('click', addNBATeam);
  $('#add-fantasy-team-btn').on('click', addFantasyTeam);

  $('#team-data-table').on('click', '.delete-btn', function() {
    const teamToDelete = $(this).data('team');
    const newData = initialNBAData.filter(item => item.team !== teamToDelete);
    renderNBAData(newData);
  });

  $('#fantasy-team-table').on('click', '.delete-fantasy-btn', function() {
    const fantasyTeamToDelete = $(this).data('fantasy-team');
    const newFantasyData = initialFantasyData.filter(item => item.fantasyTeam !== fantasyTeamToDelete);
    renderFantasyData(newFantasyData);
  });

  // Additional event handlers for updating fantasy teams

  // Initial rendering
  renderNBAData(initialNBAData);
  renderFantasyData(initialFantasyData);
</script>

</body>
</html>

```


    |   <!DOCTYPE html>

    <identifier> expected

    

    |   <!DOCTYPE html>

    illegal start of type

    

