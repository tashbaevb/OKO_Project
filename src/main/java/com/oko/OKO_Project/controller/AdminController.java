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
import org.springframework.security.access.method.P;
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
    @GetMapping("/aboutus/getByid/{id}")
    public ResponseEntity<AboutUs> getByAboutUsId(@PathVariable Long id){
        Optional<AboutUs> aboutUs = aboutUsService.getAboutUsById(id);
        return aboutUs.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("aboutus/getAll")
    public List<AboutUs> getAllAboutUs(){
        return aboutUsService.getAllAboutUs();
    }

    @PostMapping(value = "/aboutus/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AboutUs createAbooutUs(
            @RequestPart("imgUrl") MultipartFile file,
            @ModelAttribute AboutUs aboutUs
    ){
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = "/images/" + fileName;

        aboutUs.setImgUrl(fileDownloadUri);
        return aboutUsService.createAboutUs(aboutUs);
    }

    //Registry

    @GetMapping("news/getRegistryById/{id}")
    public ResponseEntity<Registry> getRegistryById(@PathVariable Long id){
        Optional<Registry> registry = registryService.getRegistryById(id);
        return registry.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("registry/getAll")
    public List<Registry> getRegistryAll(){
        return registryService.getRegistryAll();
    }

    @PostMapping(value = "registry/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Registry createRegistry(
            @RequestPart("imgUrl") MultipartFile file,
            @ModelAttribute Registry registry
    ){
        String filename = fileStorageService.storeFile(file);
        String fileDownloadUri = "/images/" + filename;

        registry.setImgUrl(fileDownloadUri);
        return registryService.createRegistry(registry);
    }

    //News
    @GetMapping("news/getAll")
    public List<News> getNewsAll(){
        return newsService.getNewsAll();
    }

    @GetMapping("news/getById/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id){
        Optional<News> news = newsService.getNewsById(id);
        return news.map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    @PostMapping(value = "news/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public News createNews(
            @RequestPart("imgUrl") MultipartFile file,
            @ModelAttribute News news
    ) {
        String filename = fileStorageService.storeFile(file);
        String fileDownloadUri = "/images/" + filename;

        news.setImgUrl(fileDownloadUri);
        return newsService.createNews(news);
    }

}
