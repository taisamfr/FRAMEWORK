document.querySelectorAll('.custom-select').forEach(select => {
  const selected = select.querySelector('.selected');
  const options = select.querySelector('.options');
  const hiddenInput = select.nextElementSibling;

  // Toggle dropdown
  selected.addEventListener('click', () => {
    closeAllSelects();
    select.classList.toggle('open');
  });

  // Handle option click
  options.querySelectorAll('li').forEach(option => {
    option.addEventListener('click', () => {
      const img = option.querySelector('img').src;
      const text = option.textContent.trim();
      const value = option.getAttribute('data-value');

      selected.innerHTML = `<img src="${img}" alt="${value}" /><span>${text}</span>`;
      hiddenInput.value = value;
      select.classList.remove('open');
    });
  });
});

// Close other selects when clicking elsewhere
document.addEventListener('click', (e) => {
  if (!e.target.closest('.custom-select')) {
    closeAllSelects();
  }
});

function closeAllSelects() {
  document.querySelectorAll('.custom-select').forEach(el => el.classList.remove('open'));
}