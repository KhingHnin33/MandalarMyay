/*========SHOW MENU================*/
const menu_toggle = document.getElementById('nav_toggle');
    const menuForm = document.getElementById('menuForm');

      if (menu_toggle) {
          menu_toggle.addEventListener('click', function (event) {
              event.preventDefault();
              menuForm.classList.toggle('show');
          });
      } 
      document.addEventListener('click', function (event) {
      if (menuForm.classList.contains('show') &&
          !menuForm.contains(event.target) &&
          event.target !== menu_toggle &&
          !menu_toggle.contains(event.target)) {
          menuForm.classList.remove('show');
      }
  });
/*=================search dropdown================*/
const search_toggle = document.getElementById('searchToggle');
    const search_dropdown = document.getElementById('searchDropdown');
    const search_input = document.getElementById('searchInput');

    // Toggle dropdown on icon click
    search_toggle.addEventListener('click', (e) => {
      e.stopPropagation();
      if (search_dropdown.style.display === 'flex') {
        search_dropdown.style.display = 'none';
      } else {
        search_dropdown.style.display = 'flex';
        search_input.focus(); // Optional: auto-focus input
      }
    });

    // Close dropdown when clicking outside
    document.addEventListener('click', (e) => {
      if (!search_toggle.contains(e.target) && !search_dropdown.contains(e.target)) {
        search_dropdown.style.display = 'none';
      }
    });

    // ================slider img
     document.addEventListener('DOMContentLoaded', () => {
      const slider = document.querySelector('.img-slider');
      const imgList = document.querySelector('.img-list');
      const imgItems = document.querySelectorAll('.img-item');
      const dots = document.querySelectorAll('.dots li');
      const prevBtn = document.getElementById('prev');
      const nextBtn = document.getElementById('next');

      if (!slider || !imgList || imgItems.length === 0 || dots.length !== imgItems.length) return;

      let activeIndex = 0;
      const total = imgItems.length;

      // Force layout width
      imgList.style.width = (total * 100) + '%';

      function updateSlider() {
        imgList.style.transform = `translateX(-${activeIndex * 100}%)`;
        dots.forEach((dot, i) => {
          dot.classList.toggle('active', i === activeIndex);
        });
      }
      updateSlider();
	  
	  if (nextBtn) {
	    nextBtn.addEventListener('click', () => {
	      activeIndex = (activeIndex + 1) % total;
	      updateSlider();
	    });
	  }

	  if (prevBtn) {
	    prevBtn.addEventListener('click', () => {
	      activeIndex = (activeIndex - 1 + total) % total;
	      updateSlider();
	    });
	  }
      dots.forEach((dot, index) => {
        dot.addEventListener('click', () => {
          activeIndex = index;
          updateSlider();
        });
      });

      let autoPlay = setInterval(() => {
        activeIndex = (activeIndex + 1) % total;
        updateSlider();
      }, 5000);

      slider.addEventListener('mouseenter', () => clearInterval(autoPlay));
      slider.addEventListener('mouseleave', () => {
        autoPlay = setInterval(() => {
          activeIndex = (activeIndex + 1) % total;
          updateSlider();
        }, 5000);
      });
    });
	
	

    //=========== swiper script 
    new Swiper('.swiper', {
      loop: true,
      spaceBetween: 20,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
        dynamicBullets: true
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev'
      },
      breakpoints: {
        0: { slidesPerView: 1 },
        768: { slidesPerView: 2 },
        1024: { slidesPerView: 3 }
      }
    });

// ================= UpArrow Key for page

      const upArrow = document.querySelector('.up-arrow-page');
    
      window.addEventListener('scroll', () => {
        if (window.scrollY > 200) {
          upArrow.classList.add('show');
        } else {
          upArrow.classList.remove('show');
        }
      });
    
      upArrow.addEventListener('click', () => {
        window.scrollTo({
          top: 0,
          behavior: 'smooth'
        });
      });
	  
	  
	  
	  
	  // Check for logout success message
	  const urlParams = new URLSearchParams(window.location.search);
	  const logoutSuccess = urlParams.get('logout');

	  if (logoutSuccess === 'success') {
	    alert('You have successfully logged out of your account!\n\nTo access customer benefits and features like Contact Us, please sign in to your account.');
	  }

	  // Optional: Remove the parameter from URL after showing message
	  if (window.history.replaceState) {
	    const url = new URL(window.location);
	    url.searchParams.delete('logout');
	    window.history.replaceState({}, document.title, url);
	  }
   