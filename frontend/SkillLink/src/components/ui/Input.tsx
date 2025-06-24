import { cn } from "clsx-for-tailwind";

interface Props {
  name: string;
  type: "text" | "email" | "password";
  className?: string;
  placeholder?: string;
  required?: boolean;
}
const Input = ({
  name,
  type,
  className,
  placeholder,
  required = false,
}: Props) => {
  return (
    <div className={className}>
      <label className={cn("font-bold text-gray-600")} htmlFor={name}>
        {name}
      </label>
      <br />
      <input
        className={cn(
          "w-full p-2 text-black rounded-sm",
          "border-2 border-gray-400 outline-none",
          "focus:border-purple-300",
        )}
        id={name}
        type={type}
        placeholder={placeholder}
        required={required}
      />
    </div>
  );
};

export default Input;
