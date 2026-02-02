//  SELECT DOM ELEMENTS (declarations at top)
const previewBox = document.querySelector('.previewbox');
const previewImg = previewBox.querySelector('.preimg img');
const closeBtn = previewBox.querySelector('.ri-close-fill');
const downloadPreviewBtn = previewBox.querySelector('.ri-download-2-line');
const searchInput = document.querySelector('.gallery-search-box input');
const cards = document.querySelectorAll('.card');

// IMAGE PREVIEW FUNCTIONALITY
document.querySelectorAll('.card img').forEach(img => {
  img.addEventListener('click', () => {
    const src = img.src;
    previewImg.src = src;
    previewBox.style.display = 'flex';
    downloadPreviewBtn.dataset.src = src;
  });
});

// CLOSE PREVIEW
previewBox.addEventListener('click', (e) => {
  if (e.target.closest('.ri-close-fill') || e.target === previewBox) {
    previewBox.style.display = 'none';
  }
});

//  DOWNLOAD LOGIC (utility + handlers)
const downloadImage = (url) => {
  const a = Object.assign(document.createElement('a'), { href: url, download: '' });
  document.body.appendChild(a);
  a.click();
  a.remove();
};

// Download from preview
downloadPreviewBtn.addEventListener('click', () => {
  const url = downloadPreviewBtn.dataset.src;
  if (url) downloadImage(url);
});

// Download from cards
document.querySelectorAll('.download-btn').forEach(btn => {
  btn.addEventListener('click', (e) => {
    e.stopPropagation();
    const src = btn.dataset.src || btn.closest('.card').querySelector('img').src;
    downloadImage(src);
  });
});

// SEARCH & FILTER BY data-tags
if (searchInput) {
  searchInput.addEventListener('input', (e) => {
    const term = e.target.value.trim().toLowerCase();
    cards.forEach(card => {
      const tags = (card.dataset.tags || '').toLowerCase();
      const titleEl = card.querySelector('.img-title span');
      const title = (titleEl ? titleEl.textContent : '').toLowerCase();
      const matches = term === '' || tags.includes(term) || title.includes(term);
      card.style.display = matches ? 'block' : 'none';
    });
  });
}





 
 
 
 
 
 
 
 
 
 
 