// statmenu.js
console.log("StatMenu.js is loaded");

document.addEventListener('DOMContentLoaded', function() {
    var statDropdowns = document.querySelectorAll('.stat-dropdown');
    console.log('Dropdowns found:', statDropdowns.length);
    
    statDropdowns.forEach(dropdown => {
        console.log('Initializing dropdown:', dropdown);
        dropdown.addEventListener('change', function() {
            updateStatOptions(statDropdowns);
        });
    });

    initializeStatDropdowns(statDropdowns);

    document.getElementById('resetButton').addEventListener('click', function() {
        resetStatDropdowns(statDropdowns);
    });
});

function initializeStatDropdowns(dropdowns) {
    var points = [15, 14, 13, 12, 10, 8];
    dropdowns.forEach(dropdown => {
        points.forEach(point => {
            var option = new Option(point, point.toString());
            dropdown.add(option);
        });
        console.log(`Dropdown [${dropdown.id}] initialized with options.`);
    });
}

function updateStatOptions(dropdowns) {
    var selectedValues = Array.from(dropdowns).map(d => d.value);
    dropdowns.forEach(dropdown => {
        var currentValue = dropdown.value;
        Array.from(dropdown.options).forEach(option => {
            option.disabled = selectedValues.includes(option.value) && option.value !== currentValue;
        });
    });
}

function resetStatDropdowns(dropdowns) {
    dropdowns.forEach(dropdown => {
        dropdown.selectedIndex = -1;
        updateStatOptions(dropdowns);
    });
    console.log('Dropdowns reset.');
}
