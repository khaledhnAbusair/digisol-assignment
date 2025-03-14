document.getElementById('searchForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const originCity = document.getElementById('originCity').value;
    const destinationCity = document.getElementById('destinationCity').value;
    const resultsDiv = document.getElementById('results');
    fetch(`${offersEndpoint}?originCity=${encodeURIComponent(originCity)}&destinationCity=${encodeURIComponent(destinationCity)}`)
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            resultsDiv.innerHTML = '';
            if (data.offers && data.offers.Package) {
                data.offers.Package.forEach(offer => {
                    resultsDiv.innerHTML += `
                        <div class="card mb-3">
                            <div class="card-body">
                                <h5 class="card-title">${offer.offerName || 'Package Offer'}</h5>
                                <p class="card-text">
                                    <strong>Origin:</strong> ${offer.originCity}<br>
                                    <strong>Destination:</strong> ${offer.destinationCity}<br>
                                    <strong>Price:</strong> $${offer.totalPrice.value} ${offer.totalPrice.currency}
                                </p>
                            </div>
                        </div>
                    `;
                });
            } else {
                resultsDiv.innerHTML = '<p>No offers found.</p>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            resultsDiv.innerHTML = '<div class="alert alert-danger" role="alert">Error fetching offers. Please try again </div>';
        });
});

