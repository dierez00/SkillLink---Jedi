import  { useState } from "react";

const user = {
  name: "Sophia",
  role: "Student",
  avatar:
    "https://lh3.googleusercontent.com/aida-public/AB6AXuBVvMtAN2tbsFF2KhQIwqW9nbiN1Op-iKjTVwadrnOBdKEsj2d_Al-J_DwghclJkYaBLS3iTZFQh5OvJoFRiY6PW7osfqadQz0F4R1yBFt6YarLC5cX161nnV4fNsPcbSPoLi4M05JHPOLJ4wSp_WVtWq_QJ5aq4nbLMi0UMpJhwSrL-wHxqUFkLc9X3h36GpM8mRCHgzV5SfFpuweW23LR2h_rZZ-FZckEpUzsnojNii8HKIruYa25uAVJO0N78XtfKqrZzuCb5L2T",
};

const navItems = [
  { label: "Home", icon: "House" },
  { label: "My Learning", icon: "Video", active: true },
  { label: "Browse", icon: "MagnifyingGlass" },
  { label: "Bookmarks", icon: "Bookmark" },
  { label: "Messages", icon: "Envelope" },
];

const coursesInProgress = [
  {
    title: "Introduction to Data Science",
    desc: "Learn the basics of data science, including data analysis, visualization, and machine learning.",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuAMvbo1iI3h_WorD5mHH4h1lzothicQX-dfRw3ApwfxjWfI5PVn_dDAUJiGBkAiYc_FTBsEfzGk0FQaQAsXYU3YRY9ogg9tXdydw4B2sFwRzO8E8dSHbXPdYT8pC-M6-uNzkNtD6coZAYd6zykV1FlyV5tn4P0Fp752EMuCEyHU5dsf0WU50uqQyvQ0vezg6bDCcuNziUayvo-_GPnI18FD0PkFNYDdzAm9LdramUk_lvPFM2VrAlyjJ2iql1hpOqTKqF5aEv8hJr1Z",
  },
  {
    title: "Web Development Fundamentals",
    desc: "Master the fundamentals of web development, including HTML, CSS, and JavaScript.",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuBCiLYr1htxM4lhWVr-lpjPtXvr0juRqPxJdA3mylH0PZmcX7wrTgnYWjZl22wqOtXgQpD909L-zk4526XKQ20DG6G65fF5XwwY5Xgni9nksYRqa_LjmZ2pszUmCLknJiDNqOqxoeoMGnJIio2-xhzeNtRsN4dHd2gaULBWw2Sqx94qa0h_NQsTpKCcQEdGS_BudbQnmqTU5jv6FvGn1Et0xapmHdRwcxI_d64hB__IOj1szwLFbgFuxJM7DKEWGbgEnSmClZ6nk2Sw",
  },
];

const upcomingLessons = [
  {
    title: "Data Science: Module 2",
    time: "10:00 AM - 11:00 AM",
  },
  {
    title: "Web Development: Project Kickoff",
    time: "1:00 PM - 2:00 PM",
  },
];

const recommendations = [
  {
    title: "Digital Marketing Strategies",
    desc: "Learn effective digital marketing techniques.",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuBC4gAbwIZWtoErP7npUbMZg8MG5mj6UCPNEz319pzzxDxPGq4XzFoUMVkBSwNfz5qrHYKTQDOVF44oJPKZRTZhL9iglZBLZ3QVlLCAxJnnXFRUk4PP1YRDjwkZSAX0hygQd5EWdU2EQjMwkDbVNX3iknHH1lvqfJNq30T2MIEossCiB_62v3cyPa6OqN2ITmaxZsymTO1Hgc79kPQFtq8HEgtYwcSrvkgfZrvpmTjiAUJuvRPxwYT3ck8FsI_LNF2G7Hr35MQ-FqgU",
  },
  {
    title: "Graphic Design Principles",
    desc: "Master the principles of graphic design.",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuB9uaSG_skGtT4AyIDLzF5dCits7I_PxPzK0NeBihx6N7_dwCidFyf5voUBt2i3Eyrefg2hdqAtqznZZQzwJC4ZopUiU4fjgCTwpJCcSwKtrPQEXQaDkSF9zra6C525cuBS-RKNrsyRMvSH0ph5X9kqtVeCJGZvgD2MZ-CBbvJIAtPLXbfWVOBbCPMLHoG-1jgJkVYZECxTNBoqQbg3N3Bfntb7MHlT5LTWjp2_GgO9aJm5guuJ46hgAE2ZJSnLmKHdRGFZXPoBqHhT",
  },
];

const tabs = ["In progress", "Completed", "Archived"];

const MyLearning = () => {
  const [activeTab, setActiveTab] = useState("In progress");

  return (
    <div className="flex min-h-screen bg-white">
      {/* Sidebar */}
      <aside className="w-80 min-h-[700px] flex flex-col justify-between bg-white p-4 border-r">
        <div className="flex flex-col gap-4">
          {/* Profile */}
          <div className="flex gap-3">
            <div
              className="bg-center bg-no-repeat aspect-square bg-cover rounded-full size-10"
              style={{ backgroundImage: `url(${user.avatar})` }}
            ></div>
            <div className="flex flex-col">
              <h1 className="text-[#111418] text-base font-medium">{user.name}</h1>
              <p className="text-[#60758a] text-sm">{user.role}</p>
            </div>
          </div>
          {/* Navigation */}
          <div className="flex flex-col gap-2">
            {navItems.map((item) => (
              <div
                key={item.label}
                className={`flex items-center gap-3 px-3 py-2 rounded-lg ${
                  item.active ? "bg-[#f0f2f5]" : ""
                }`}
              >
                <span className="text-[#111418]">

                  <svg width="24" height="24" fill="currentColor">
                    <circle cx="12" cy="12" r="10" />
                  </svg>
                </span>
                <p
                  className={`text-sm font-medium ${
                    item.active ? "text-[#111418]" : "text-[#111418]"
                  }`}
                >
                  {item.label}
                </p>
              </div>
            ))}
          </div>
        </div>
      </aside>

      {/* Main content */}
      <main className="flex-1 flex flex-col max-w-[960px] mx-auto">
        <div className="flex flex-wrap justify-between gap-3 p-4">
          <p className="text-[#111418] tracking-light text-[32px] font-bold leading-tight min-w-72">
            My Learning
          </p>
        </div>

        {/* Tabs */}
        <div className="pb-3">
          <div className="flex border-b border-[#dbe0e6] px-4 gap-8">
            {tabs.map((tab) => (
              <button
                type="button"
                key={tab}
                className={`flex flex-col items-center justify-center border-b-[3px] pb-[13px] pt-4 ${
                  activeTab === tab
                    ? "border-b-[#111418] text-[#111418] font-bold"
                    : "border-b-transparent text-[#60758a] font-bold"
                }`}
                onClick={() => setActiveTab(tab)}
              >
                <p className="text-sm leading-normal tracking-[0.015em]">{tab}</p>
              </button>
            ))}
          </div>
        </div>

        {/* Cursos en progreso */}
        {activeTab === "In progress" && (
          <>
            <h2 className="text-[#111418] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 pb-3 pt-5">
              In progress
            </h2>
            {coursesInProgress.map((course) => (
              <div className="p-4" key={course.title}>
                <div className="flex items-stretch justify-between gap-4 rounded-lg">
                  <div className="flex flex-[2_2_0px] flex-col gap-4">
                    <div className="flex flex-col gap-1">
                      <p className="text-[#111418] text-base font-bold leading-tight">
                        {course.title}
                      </p>
                      <p className="text-[#60758a] text-sm">{course.desc}</p>
                    </div>
                    <button type="button" className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-lg h-8 px-4 flex-row-reverse bg-[#f0f2f5] text-[#111418] text-sm font-medium w-fit">
                      <span className="truncate">Continue</span>
                    </button>
                  </div>
                  <div
                    className="w-full bg-center bg-no-repeat aspect-video bg-cover rounded-lg flex-1"
                    style={{ backgroundImage: `url(${course.image})` }}
                  ></div>
                </div>
              </div>
            ))}
          </>
        )}

        {/* Próximas lecciones */}
        <h2 className="text-[#111418] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 pb-3 pt-5">
          Upcoming Lessons
        </h2>
        {upcomingLessons.map((lesson) => (
          <div className="flex items-center gap-4 bg-white px-4 min-h-[72px] py-2" key={lesson.title}>
            <div className="text-[#111418] flex items-center justify-center rounded-lg bg-[#f0f2f5] shrink-0 size-12">
              {/* Icono calendario */}
              <svg width="24" height="24" fill="currentColor">
                <rect width="24" height="24" rx="4" />
              </svg>
            </div>
            <div className="flex flex-col justify-center">
              <p className="text-[#111418] text-base font-medium line-clamp-1">{lesson.title}</p>
              <p className="text-[#60758a] text-sm line-clamp-2">{lesson.time}</p>
            </div>
          </div>
        ))}

        {/* Recomendaciones */}
        <h2 className="text-[#111418] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 pb-3 pt-5">
          Recommended for you
        </h2>
        <div className="flex overflow-x-auto p-4 gap-3">
          {recommendations.map((rec) => (
            <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-40" key={rec.title}>
              <div
                className="w-full bg-center bg-no-repeat aspect-[3/4] bg-cover rounded-lg flex flex-col"
                style={{ backgroundImage: `url(${rec.image})` }}
              ></div>
              <div>
                <p className="text-[#111418] text-base font-medium">{rec.title}</p>
                <p className="text-[#60758a] text-sm">{rec.desc}</p>
              </div>
            </div>
          ))}
        </div>
      </main>
    </div>
  );
};

export default MyLearning;
