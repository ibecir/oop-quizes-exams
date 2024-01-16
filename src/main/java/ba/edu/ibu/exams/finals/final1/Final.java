package ba.edu.ibu.exams.finals.final1;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum CaseFormat {
    ORDINARY,
    UPPER_CASE,
    LOWER_CASE
}

enum Currency {
    AUD,
    BRL,
    CAD,
    CHF,
    DKK,
    EUR,
    GBP,
    PLN,
    SGD,
    TRY,
    USD
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteFormat {
    CaseFormat format() default CaseFormat.ORDINARY;
}

class InvalidCastException extends RuntimeException {
    public InvalidCastException(String message) {
        super(message);
    }

    public InvalidCastException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Job {
    private int year;
    @WriteFormat(format = CaseFormat.UPPER_CASE)
    private String jobTitle;
    private String category;
    private Currency currency;
    private int salary;
    @WriteFormat(format = CaseFormat.UPPER_CASE)
    private String residence;
    @WriteFormat(format = CaseFormat.LOWER_CASE)
    private String experienceLevel;
    private String companyLocation;
    private String companySize;

    public Job(JobBuilder builder) {
        this.year = builder.year;
        this.jobTitle = builder.jobTitle;
        this.category = builder.category;
        this.currency = builder.currency;
        this.salary = builder.salary;
        this.residence = builder.residence;
        this.experienceLevel = builder.experienceLevel;
        this.companyLocation = builder.companyLocation;
        this.companySize = builder.companySize;
    }

    public int getYear() {
        return year;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCategory() {
        return category;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getSalary() {
        return salary;
    }

    public String getResidence() {
        return residence;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public String getCompanySize() {
        return companySize;
    }

    public static class JobBuilder {
        private int year;
        private String jobTitle;
        private String category;
        private Currency currency;
        private int salary;
        private String residence;
        private String experienceLevel;
        private String companyLocation;
        private String companySize;

        public JobBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public JobBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public JobBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public JobBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public JobBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public JobBuilder setResidence(String residence) {
            this.residence = residence;
            return this;
        }

        public JobBuilder setExperienceLevel(String experienceLevel) {
            this.experienceLevel = experienceLevel;
            return this;
        }

        public JobBuilder setCompanyLocation(String companyLocation) {
            this.companyLocation = companyLocation;
            return this;
        }

        public JobBuilder setCompanySize(String companySize) {
            this.companySize = companySize;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }
}

public class Final {
    private List<Job> jobs;

    public Final(String filename) {
        this.jobs = loadJobs(filename);
    }

    private static List<Job> loadJobs(String filename) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filename)
            );
            List<String> lines = reader.lines().collect(Collectors.toList());
            List<Job> jobs = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++) {
                String[] tempLine = lines.get(i).split(";");
                if (tempLine[0] == "" || tempLine[1] == "" || tempLine[2] == "")
                    throw new InvalidCastException("The values must not be empty", new ClassCastException("Values are empty"));

                jobs.add(
                        new Job.JobBuilder()
                                .setYear(Integer.parseInt(tempLine[0]))
                                .setJobTitle(tempLine[1])
                                .setCategory(tempLine[2])
                                .setCurrency(Currency.valueOf(tempLine[3]))
                                .setSalary(Integer.parseInt(tempLine[4]))
                                .setResidence(tempLine[5])
                                .setExperienceLevel(tempLine[6])
                                .setCompanyLocation(tempLine[7])
                                .setCompanySize(tempLine[8])
                                .build()
                );
            }
            return jobs;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> getJobs() {
        return this.jobs;
    }
}

class CustomFileWriter {
    public static void writeReport(String outputFilename, List<Job> jobs) {
        Class<?> clazz = Job.class;
        Field[] fields = clazz.getDeclaredFields();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            for (int i = 0; i < fields.length; i++) {
                writer.write(fields.length - 1 == i ? fields[i].getName().toUpperCase().concat("\n") : fields[i].getName().toUpperCase().concat(","));
            }
            for (Job job : jobs) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    if (fields[i].isAnnotationPresent(WriteFormat.class)) {
                        CaseFormat format = fields[i].getAnnotation(WriteFormat.class).format();
                        switch (format){
                            case LOWER_CASE -> writer.write(fields.length - 1 == i ? fields[i].get(job).toString().toLowerCase().concat("\n") : fields[i].get(job).toString().toLowerCase().concat(","));
                            case UPPER_CASE -> writer.write(fields.length - 1 == i ? fields[i].get(job).toString().toUpperCase().concat("\n") : fields[i].get(job).toString().toUpperCase().concat(","));
                        }
                    } else {
                        writer.write(fields.length - 1 == i ? fields[i].get(job).toString().concat("\n") : fields[i].get(job).toString().toLowerCase().concat(","));
                    }
                }
            }
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class MainRun {
    public static void main(String[] args) {
        Final finalInstance = new Final("first-group.csv");

        CustomFileWriter.writeReport("first-group-output.csv", finalInstance.getJobs());
    }
}
