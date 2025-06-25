
import { CourseCard } from "../components/features/courses/CourseCard";
import { CourseFilters } from "../components/features/courses/CourseFilters";

const courses = [
  {
    title: "Introduction to Data Science",
    duration: "4 hours",
    imageUrl: "https://lh3.googleusercontent.com/aida-public/AB6AXuDuAP9tVz9Bj1dXkyi2jmceIFZXUEsdp3BZHks3mv8jbGtZQ0haaoO3__LN7fe_jPPZqDhYrG5884ygAmVjl5tpolQ-lLhJnl2m3aP2fBZRm82InKvAmzVHexu2PRgFzPkHpqq_OqS3oQ2Z7I8ig6yC3ekZXUvUii_PplCiTjpUz8wjxdlPh3JItKTR8yKcxELPi_rLUouLfP54rLDlgWK6YDlEwiVPz5xshzhxqqeF7xNoqTOeF4gPS2YOGK_LMhK_fVQO62CCR3wj"
  },
  {
    title: "Digital Marketing Fundamentals",
    duration: "6 hours",
    imageUrl: "https://lh3.googleusercontent.com/aida-public/AB6AXuDWPjHipW_AVJGrQuDkQkUc7HgJqJH-G2_RlgiKbOyrYFKiV0UqStZvIVnuaUcfuHj2-gEYh7LZBVwJXlynemaL0cgzejtWtPTg1l5A1zXHYZ8qrmOLJlvuAVVz_cS-U6eHPPRFkN6IvsuP3ofoj8NaWN0v9dF0z-GM4guZqQ_Co1Dx4_umkCE_aXbkkWSd4iHewOy8jPqlPtJsxQ-By5eS39riQX5Xrc6ZXy-SF2JRnqEkF6t4i4SOkt15-MdwsAoI6IUZOhDn8J-x"
  },
  
];

export const CoursesPage = () => {
  return (
    <div className="relative flex size-full min-h-screen flex-col bg-white overflow-x-hidden"
      style={{
        '--checkbox-tick-svg': 'url("data:image/svg+xml,%3csvg viewBox=%270 0 16 16%27 fill=%27rgb(255,255,255)%27 xmlns=%27http://www.w3.org/2000/svg%27%3e%3cpath d=%27M12.207 4.793a1 1 0 010 1.414l-5 5a1 1 0 01-1.414 0l-2-2a1 1 0 011.414-1.414L6.5 9.086l4.293-4.293a1 1 0 011.414 0z%27/%3e%3c/svg%3e")',
        '--radio-dot-svg': 'url("data:image/svg+xml,%3csvg viewBox=%270 0 16 16%27 fill=%27rgb(18,20,22)%27 xmlns=%27http://www.w3.org/2000/svg%27%3e%3ccircle cx=%278%27 cy=%278%27 r=%273%27/%3e%3c/svg%3e")',
        fontFamily: 'Lexend, "Noto Sans", sans-serif'
      } as React.CSSProperties}
    >
      
      
      <div className="flex flex-1 justify-center py-5 px-6 gap-1">
        <CourseFilters />
        
        <div className="flex flex-col max-w-[960px] flex-1">
          <div className="flex flex-wrap justify-between gap-3 p-4">
            <div className="flex min-w-72 flex-col gap-3">
              <h1 className="text-[#121416] tracking-light text-[32px] font-bold leading-tight">Browse Courses</h1>
              <p className="text-[#6a7581] text-sm font-normal leading-normal">
                Explore our extensive library of courses to enhance your skills and knowledge.
              </p>
            </div>
          </div>
          
          <div className="flex gap-3 p-3 flex-wrap pr-4">
            {['All', 'Technology', 'Business', 'Arts', 'Science'].map((category) => (
              <div key={category} className="flex h-8 shrink-0 items-center justify-center gap-x-2 rounded-full bg-[#f1f2f4] pl-4 pr-4">
                <p className="text-[#121416] text-sm font-medium leading-normal">{category}</p>
              </div>
            ))}
          </div>
          
          <div className="grid grid-cols-[repeat(auto-fit,minmax(158px,1fr))] gap-3 p-4">
            {courses.map((course, index) => (
              <CourseCard key={index} {...course} />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};