// Initialize Swipers with LOOP enabled
const swiperInstances = [];
document.querySelectorAll('.swiper').forEach(container => {
  const swiper = new Swiper(container, {
    slidesPerView: 1,
    spaceBetween: 20,
    loop: true, // 🔥 Enable continuous looping
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    breakpoints: {
		640: { slidesPerView: 1},
		      690: { slidesPerView: 2 },
		      1024: { slidesPerView: 3 }
    }
  });
  swiperInstances.push(swiper);
});

const formSearch = document.getElementById('FormSearch');
if (formSearch) {
  formSearch.addEventListener('submit', function(e) {
    e.preventDefault(); // Prevent page reload

    // Scroll to the category chips section
    const chipsSection = document.querySelector('.chips');
    if (chipsSection) {
      chipsSection.scrollIntoView({ 
        behavior: 'smooth',
        block: 'start'
      });
    }
  });
}
document.querySelectorAll('.chip').forEach(chip => {
  chip.addEventListener('click', function() {
    document.querySelectorAll('.chip').forEach(c => 
      c.setAttribute('data-active', 'false')
    );
    this.setAttribute('data-active', 'true');
    
    const filter = this.dataset.filter;
    
    document.querySelectorAll('.swiper-slide').forEach(slide => {
      slide.style.display = '';
      if (filter !== 'all') {
        const tags = slide.dataset.tags || '';
        if (!tags.includes(filter)) {
          slide.style.display = 'none';
        }
      }
    });
    
    swiperInstances.forEach(swiper => swiper.update());
  });
});

document.querySelectorAll('a').forEach(link => {
  const href = link.getAttribute('href');
  
  // Only prevent default if it's a placeholder link
  if (href === '#' || href === '' || !href) {
    link.addEventListener('click', (e) => {
      e.preventDefault();
      // Optional: do nothing, or trigger a custom action
    });
  }
});