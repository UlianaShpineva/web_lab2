const coords = new Coords();
window.onload = function () {

    coords.lastR = $('p[hidden="hidden"]').text();
    if (coords.lastR == null || coords.lastR == '') {
        coords.lastR = 1;
    }
    const printer = new Printer();
    printer.drawStart();

    updateButtonsClasses();

    let btn = document.querySelector("input[type=text]");
    btn.addEventListener("input", validateY);

    function updateButtonsClasses() {
        document.querySelectorAll("#xButtons > button").forEach((btn) => {
            btn.classList.remove("selected")
            if (coords.selectedX === parseInt(btn.innerHTML)) {
                btn.classList.add("selected")
            }
        })
    }

    document.querySelectorAll("#xButtons > button").forEach((btn) => {
        btn.addEventListener("click", () => {
            coords.selectedX = parseInt(btn.innerHTML)
            updateButtonsClasses()
        })
    })

    getR();

    document.querySelectorAll("input[type=radio]").forEach((btn) => {
        btn.addEventListener("click", () => {
            coords.selectedR = parseFloat(btn.value);
            // updateButtonsClasses()
            getR();
            printer.redraw(coords.selectedR);
        })
    })

    function getR() {
        var el = document.getElementsByName('R-radio_group');
        for (i = 0; i < el.length; i++) {
            if (el[i].checked) {
                coords.selectedR = el[i].value;
            }
        }
    }

    printer.canvas.addEventListener('click', function(event) {
        printer.clickPoint(event);
    });

    document.getElementById('checkButton').onclick = async function () {
        if (validateY() && validateR()) {
            let selectedY = document.getElementById("yInput").value.replace(',', '.');
            sendReq(coords.selectedX, selectedY, coords.selectedR);
            location.reload();
        }
    }

    // $('form').submit(function(e) {
    //     e.preventDefault();
    // })

    document.getElementById('clearButton').onclick = async function () {
        sendDelete();
        location.reload();
    }

    // document.getElementById('goBackButton').onclick = function () {
    //     location.replace('index.jsp');
    // }
}
async function sendReq(x, y, r) {
    $.ajax({
        url: document.URL + "controller", //./
        type: "POST",
        dataType: "json",
        async: false,
        data: {"x": x, "y": y, "r": r},
        success: function (resp) {
            console.log(resp);
        },
        error: function (resp) {
            console.log(resp);
            location.replace("error.jsp")
        }
    });
}

async function sendDelete() {
    $.ajax({
        url: document.URL + "controller", //./
        type: "DELETE",
        async: false
    });
}

function validateY() {
    element = document.getElementById("yInput");
    y = element.value.replace(',', '.');
    if (!isNumeric(y) || parseFloat(y) >= 5 || parseFloat(y) <= -5) {
        element.setCustomValidity("Please enter an integer between -5 and 5 (not including)");
        element.reportValidity();
        return false;
    } else {
        element.setCustomValidity("");
        element.reportValidity();
        return true;
    }
}

function validateR() {
    el = coords.selectedR;
    setError = document.getElementById("errorRadio");
    if (!isNumeric(el)) {
        // setError = document.getElementById("errorRadio");
        setError.setCustomValidity("Please choose R");
        setError.reportValidity();
        return false;
    } else {
        setError.setCustomValidity("");
        setError.reportValidity();
        return true;
    }
}

function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}



