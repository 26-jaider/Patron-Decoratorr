const optionInputs = [
    ...document.querySelectorAll("[data-option]")
];

const counter = document.getElementById("counter");
const totalPrice = document.getElementById("totalPrice");
const serviceList = document.getElementById("serviceList");
const message = document.getElementById("message");
const activateButton = document.getElementById("activateButton");
const resetButton = document.getElementById("resetButton");

async function updatePass() {
    const options = optionInputs
        .filter(input => input.checked)
        .map(input => input.dataset.option);

    counter.textContent =
        `${options.length} ADD-ON${options.length === 1 ? "" : "S"}`;

    try {
        const response = await fetch(
            `/api/pass?options=${encodeURIComponent(options.join(","))}`
        );

        if (!response.ok) {
            throw new Error(`Museum service returned ${response.status}`);
        }

        const pass = await response.json();

        totalPrice.textContent =
            `$${pass.price.toFixed(2)}`;

        serviceList.innerHTML = pass.services
            .map(service =>
                `<span class="service">${service}</span>`
            )
            .join("");

    } catch (error) {
        message.textContent =
            "Unable to connect to the museum service.";
    }
}

optionInputs.forEach(input => {
    input.addEventListener("change", updatePass);
});

activateButton.addEventListener("click", async () => {
    const options = optionInputs
        .filter(input => input.checked)
        .map(input => input.dataset.option);

    activateButton.disabled = true;
    activateButton.textContent = "ACTIVATING...";
    message.textContent = "";

    try {
        const response = await fetch(
            `/api/pass?options=${encodeURIComponent(options.join(","))}`
        );

        if (!response.ok) {
            throw new Error(`Museum service returned ${response.status}`);
        }

        const pass = await response.json();

        message.textContent = pass.activation;

    } catch (error) {
        message.textContent =
            "Pass activation failed.";
    } finally {
        setTimeout(() => {
            activateButton.disabled = false;
            activateButton.innerHTML =
                'Activate my pass <span>↗</span>';
        }, 700);
    }
});

resetButton.addEventListener("click", () => {
    optionInputs.forEach(input => {
        input.checked = false;
    });

    message.textContent = "";
    updatePass();
});

updatePass();
