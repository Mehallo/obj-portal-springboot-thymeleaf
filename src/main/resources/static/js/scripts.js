// Reset everything:
function filter(pageNo) {
    //alert("Filter Script called!");
    //const filterButton = document.querySelector("#filter").innerHTML;
    const filterButton = document.getElementById("filter").value;
    //alert("FilterButton Value : " + filterButton);
    window.location.href = '/api/v1/groups/page/' + pageNo + '/' + filterButton;
}

function downloadCSV(csv, filename) {
    var csvFile;
    var downloadLink;

    // CSV file
    csvFile = new Blob([csv], {type: "text/csv"});
    // Download link
    downloadLink = document.createElement("a");
    // File name
    downloadLink.download = filename;
    // Create a link to the file
    downloadLink.href = window.URL.createObjectURL(csvFile);
    // Hide download link
    downloadLink.style.display = "none";
    // Add the link to DOM
    document.body.appendChild(downloadLink);
    // Click download link
    downloadLink.click();
}

function exportTableToCSV(filename) {
    var csv = [];
    var rows = document.querySelectorAll("table tr");

    for (var i = 0; i < rows.length; i++) {
        var row = [], cols = rows[i].querySelectorAll("td, th");

        for (var j = 0; j < cols.length; j++)
            row.push(cols[j].innerText);

        csv.push(row.join(","));
    }

    // Download CSV file
    downloadCSV(csv.join("\n"), filename);

}

function uploadFileToServer(theForm)
{
    console.log("upload file");
    var file = document.getElementById('fileItem').files[0];
    window.location.href = '/api/v1/add/updateBulk/'+file;
    //window.location.href = '/api/v1/add/update/A1/gA1/YYYYNN';

}