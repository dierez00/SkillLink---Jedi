import { Link, useParams } from "react-router-dom";

// Datos simulados
const lessons = [
	{ id: 1, title: "Lesson 1: Getting Started", desc: "Introduction" },
	{ id: 2, title: "Lesson 2: Core Concepts", desc: "Understanding the Basics" },
	{ id: 3, title: "Lesson 3: Deep Dive", desc: "Advanced Techniques" },
	{ id: 4, title: "Lesson 4: Hands-On Project", desc: "Practical Application" },
	{ id: 5, title: "Lesson 5: Wrap-Up", desc: "Review and Next Steps" },
	{ id: 6, title: "Lesson 6: Quiz", desc: "Final Assessment" },
];

const keyConcepts = [
	"Setting up your development environment",
	"Understanding the course structure",
	"How to access resources",
];

const CourseLesson = () => {
	const { courseId, lessonId } = useParams();

	const currentLesson =
		lessons.find((l) => l.id === Number(lessonId)) || lessons[0];

	return (
		<div className="relative flex min-h-screen flex-col bg-white">
			{/* Header */}
			<header className="flex items-center justify-between border-b border-[#f1f2f4] px-10 py-3">
				<div className="flex items-center gap-8">
					<div className="flex items-center gap-4 text-[#121416]">
						<div className="size-4">
							<svg
								viewBox="0 0 48 48"
								fill="none"
								className="w-6 h-6 text-[#121416]"
							>
								<circle cx="24" cy="24" r="20" fill="currentColor" />
							</svg>
						</div>
						<h2 className="text-[#121416] text-lg font-bold">EduLearn</h2>
					</div>
					<nav className="flex items-center gap-9">
						<Link to="/" className="text-[#121416] text-sm font-medium">
							Home
						</Link>
						<Link
							to="/my-learning"
							className="text-[#121416] text-sm font-medium"
						>
							My Courses
						</Link>
						<Link to="/browse" className="text-[#121416] text-sm font-medium">
							Browse
						</Link>
					</nav>
				</div>
				<div className="flex flex-1 justify-end gap-8">
					<div
						className="bg-center bg-no-repeat aspect-square bg-cover rounded-full size-10"
						style={{
							backgroundImage: `url("https://randomuser.me/api/portraits/women/44.jpg")`,
						}}
					/>
				</div>
			</header>

			<div className="flex flex-1 gap-1 px-6 py-5 justify-center">
				<aside className="flex flex-col w-80">
					<h2 className="text-[#121416] text-[22px] font-bold px-4 pb-3 pt-5">
						Course Outline
					</h2>
					{lessons.map((lesson, idx) => (
						<div
							key={lesson.id}
							className={`flex items-center gap-4 bg-white px-4 min-h-[72px] py-2 justify-between rounded-lg mb-2
                ${Number(lessonId) === lesson.id ? "border border-[#0c7ff2] bg-[#f0f8ff]" : ""}`}
						>
							<div className="flex flex-col justify-center">
								<p className="text-[#121416] text-base font-medium">
									{lesson.title}
								</p>
								<p className="text-[#6a7581] text-sm">{lesson.desc}</p>
							</div>
							{idx < Number(lessonId) ? (
								<span className="text-green-500">
									<svg width="24" height="24" fill="currentColor">
										<path d="M229.66,77.66l-128,128a8,8,0,0,1-11.32,0l-56-56a8,8,0,0,1,11.32-11.32L96,188.69,218.34,66.34a8,8,0,0,1,11.32,11.32Z" />
									</svg>
								</span>
							) : null}
						</div>
					))}
				</aside>

				{/* Main Content */}
				<main className="flex flex-col flex-1 max-w-[960px]">
					{/* Breadcrumb */}
					<div className="flex flex-wrap gap-2 p-4">
						<Link
							to="/my-learning"
							className="text-[#6a7581] text-base font-medium"
						>
							My Courses
						</Link>
						<span className="text-[#6a7581] text-base font-medium">/</span>
						<span className="text-[#6a7581] text-base font-medium">
							Course {courseId}
						</span>
						<span className="text-[#6a7581] text-base font-medium">/</span>
						<span className="text-[#121416] text-base font-medium">
							{currentLesson.title}
						</span>
					</div>

					{/* Título de la lección */}
					<h2 className="text-[#121416] text-[28px] font-bold px-4 pb-3 pt-5">
						{currentLesson.title}
					</h2>

					{/* Video o imagen */}
					<div className="p-4">
						<div
							className="relative flex items-center justify-center bg-[#121416] bg-cover bg-center aspect-video rounded-xl p-4"
							style={{
								backgroundImage:
									"url('https://images.unsplash.com/photo-1513258496099-48168024aec0?auto=format&fit=crop&w=800&q=80')",
							}}
						>
							<button type="button" className="flex items-center justify-center rounded-full size-16 bg-black/40 text-white">
								<svg
									width="32"
									height="32"
									fill="currentColor"
									viewBox="0 0 256 256"
								>
									<path d="M240,128a15.74,15.74,0,0,1-7.6,13.51L88.32,229.65a16,16,0,0,1-16.2.3A15.86,15.86,0,0,1,64,216.13V39.87a15.86,15.86,0,0,1,8.12-13.82,16,16,0,0,1,16.2.3L232.4,114.49A15.74,15.74,0,0,1,240,128Z" />
								</svg>
							</button>
						</div>
					</div>

					{/* Resumen de la lección */}
					<h3 className="text-[#121416] text-lg font-bold px-4 pb-2 pt-4">
						Lesson Summary
					</h3>
					<p className="text-[#121416] text-base font-normal pb-3 pt-1 px-4">
						This introductory lesson will guide you through the initial setup
						and basic concepts of programming. You'll learn about the tools and
						environments used by developers, and gain a foundational
						understanding of how programs work. By the end of this lesson,
						you'll be ready to write your first simple program.
					</p>

					{/* Conceptos clave */}
					<h3 className="text-[#121416] text-lg font-bold px-4 pb-2 pt-4">
						Key Concepts
					</h3>
					<div className="px-4">
						{keyConcepts.map((concept, idx) => (
							<label key={idx} className="flex gap-x-3 py-3 items-center">
								<input
									type="checkbox"
									className="h-5 w-5 rounded border-[#dde0e3] border-2 bg-transparent text-[#528bc5] focus:ring-0"
								/>
								<span className="text-[#121416] text-base">{concept}</span>
							</label>
						))}
					</div>
				</main>
			</div>
		</div>
	);
};

export default CourseLesson;
