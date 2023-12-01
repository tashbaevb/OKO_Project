package com.oko.OKO_Project.controller;

import com.oko.OKO_Project.entity.*;
import com.oko.OKO_Project.enums.GovOrgansType;
import com.oko.OKO_Project.enums.NpaType;
import com.oko.OKO_Project.enums.UnionistsType;
import com.oko.OKO_Project.service.*;
import com.oko.OKO_Project.service.impl.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final NpaService npaService;
    private final GovOrgansService govOrgansService;
    private final UnionistsService unionistsService;
    private final CoursesService coursesService;
    private final AboutUsService aboutUsService;
    private final FileStorageService fileStorageService;
    private final RegistryService registryService;
    private final NewsService newsService;
    private final VacancyService vacancyService;


    // НПА
    @PostMapping("/npa/create")
    public Npa createNpa(@RequestBody Npa npa, @RequestParam NpaType type) {
        npa.setNpaType(type);
        return npaService.createNpa(npa);
    }

    @GetMapping("/npa/getAll")
    public List<Npa> getAllNpa() {
        return npaService.getAllNpa();
    }

    @GetMapping("/npa/getByType/{type}")
    public List<Npa> getNpaByType(@PathVariable NpaType type) {
        return npaService.getNpaByType(type);
    }


    // Органы Управления
    @PostMapping("/govOrgan/create")
    public GovOrgan createGovOrgan(@RequestBody GovOrgan govOrgans, @RequestParam GovOrgansType govOrgansType) {
        govOrgans.setGovOrgansType(govOrgansType);
        return govOrgansService.createGovOrgans(govOrgans);
    }

    @GetMapping("/govOrgan/getAll")
    public List<GovOrgan> getAllGovOrgan() {
        return govOrgansService.getAllGovOrgan();
    }

    @GetMapping("/govOrgan/getByType/{type}")
    public List<GovOrgan> getByGovOrganType(@PathVariable GovOrgansType type) {
        return govOrgansService.getGovOrganByType(type);
    }


    // Члены Объединения
    @PostMapping("/unionists/create")
    public Unionists createUnionists(@RequestBody Unionists unionists, @RequestParam UnionistsType unionistsType) {
        unionists.setUnionistsType(unionistsType);
        return unionistsService.createUnionists(unionists);
    }

    @GetMapping("/unionists/getAll")
    public List<Unionists> getAllUnionists() {
        return unionistsService.getAllUnionists();
    }

    @GetMapping("/unionists/getByType/{type}")
    public List<Unionists> getByUnionistsType(@PathVariable UnionistsType type) {
        return unionistsService.getUnionistsByType(type);
    }


    // Курсы
    @PostMapping("/courses/create")
    public Courses createCourses(@RequestBody Courses courses) {
        return coursesService.createCourses(courses);
    }

    @GetMapping("/courses/getAll")
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }

    @GetMapping("/courses/getById/{id}")
    public ResponseEntity<Courses> getByCoursesId(@PathVariable Long id) {
        Optional<Courses> courses = coursesService.getCoursesById(id);

        return courses.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    //AboutUS
    @PostMapping(value = "/aboutUs/create")
    public AboutUs createAboutUs( @RequestBody AboutUs aboutUs) {
        return aboutUsService.createAboutUs(aboutUs);
    }

    @GetMapping("aboutUs/getAll")
    public List<AboutUs> getAllAboutUs() {
        return aboutUsService.getAllAboutUs();
    }

    @GetMapping("/aboutUs/getById/{id}")
    public ResponseEntity<AboutUs> getByAboutUsId(@PathVariable Long id) {
        Optional<AboutUs> aboutUs = aboutUsService.getAboutUsById(id);
        return aboutUs.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }


    //Registry
    @PostMapping(value = "registry/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Registry createRegistry(@RequestBody Registry registry) {

        return registryService.createRegistry(registry);
    }

    @GetMapping("registry/getAll")
    public List<Registry> getRegistryAll() {
        return registryService.getRegistryAll();
    }

    @GetMapping("registry/getById/{id}")
    public ResponseEntity<Registry> getRegistryById(@PathVariable Long id) {
        Optional<Registry> registry = registryService.getRegistryById(id);
        return registry.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }


    //News
    @PostMapping(value = "news/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public News createNews(@RequestPart("file") MultipartFile file, @ModelAttribute News news) {
        String filename = fileStorageService.storeFile(file);
        String fileDownloadUri = "/images/" + filename;

        news.setImgUrl(fileDownloadUri);
        return newsService.createNews(news);
    }

    @GetMapping("news/getAll")
    public List<News> getNewsAll() {
        return newsService.getNewsAll();
    }

    @GetMapping("news/getById/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        Optional<News> news = newsService.getNewsById(id);
        return news.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }


    //Vacancy
    @PostMapping("vacancy/create")
    public Vacancy createVacancy(@RequestBody Vacancy vacancy) {
        return vacancyService.createVacancy(vacancy);
    }

    @GetMapping("vacancy/getAll")
    public List<Vacancy> getVacancyAll() {
        return vacancyService.getVacancyAll();
    }

    @GetMapping("vacancy/getById/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable Long id) {
        Optional<Vacancy> vacancy = vacancyService.getVacancyById(id);
        return vacancy.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }
}
