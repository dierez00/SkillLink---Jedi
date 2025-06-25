interface CourseCardProps {
  title: string;
  duration: string;
  imageUrl: string;
}

export const CourseCard = ({ title, duration, imageUrl }: CourseCardProps) => {
  return (
    <div className="flex flex-col gap-3 pb-3">
      <div
        className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-xl"
        style={{ backgroundImage: `url(${imageUrl})` }}
      ></div>
      <div>
        <p className="text-[#121416] text-base font-medium leading-normal">{title}</p>
        <p className="text-[#6a7581] text-sm font-normal leading-normal">{duration}</p>
      </div>
    </div>
  );
};