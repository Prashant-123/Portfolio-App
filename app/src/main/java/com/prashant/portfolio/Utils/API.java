package com.prashant.portfolio.Utils;

import com.prashant.portfolio.AboutMe.AboutMeModel;
import com.prashant.portfolio.AboutMe.AwardsModel;
import com.prashant.portfolio.AboutMe.SkillSetModel;
import com.prashant.portfolio.Education.CoursesModel;
import com.prashant.portfolio.Education.HigherStudiesModel;
import com.prashant.portfolio.Education.Placeholder;
import com.prashant.portfolio.Projects.ProjectsModel;
import com.prashant.portfolio.WorkEx.WorkexModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/about")
    Call<AboutMeModel> aboutMe();

    @GET("/education/hst")
    Call<List<HigherStudiesModel>> hst();
    @GET("/education/courses")
    Call<List<CoursesModel>> courses();
    @GET("/education/schooling")
    Call<String> schooling();
    @GET("/education/images")
    Call<Placeholder> placeholder();

    @GET("/awards")
    Call<List<AwardsModel>> getAwards();

    @GET("/workex")
    Call<List<WorkexModel>> experience();

    @GET("/por")
    Call<List<WorkexModel>> POR();

    @GET("/projects")
    Call<List<ProjectsModel>> Projects();

    @GET("/skills")
    Call<List<SkillSetModel>> Skills();
}