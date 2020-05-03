package io.javabrains.coronvirustracker.controllers;

import io.javabrains.coronvirustracker.models.LocationStats;
import io.javabrains.coronvirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model) {

        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat ->stat.getLatestTotalCases()).sum();
        int totalCasesNewCases = allStats.stream().mapToInt(stat ->stat.getDiffFromPreviousDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalCasesNewCases", totalCasesNewCases);


        return "home";
    }
}
