import LikeButton from './LikeButton';
import IconWithCounts from '../IconWithCounts';

import CommentIcon from '/public/icons/comment.svg';
import HeartIcon from '/public/icons/heart.svg';
import StarIcon from '/public/icons/star.svg';

import type { TPlace } from './types';

// 외부 placeholder 이미지 사용중, no-img-element 린트 에러 발생
// 차후 next/image 사용하게 변경 예정
export default function Place({
  data,
  order,
  variant,
}: {
  data: TPlace;
  order: number;
  variant: 'primary' | 'secondary';
}) {
  const { region, liked, imageUrl, title, likeCount, commentCount, rating } =
    data;

  const postSize = variant === 'primary' ? 'w-[350px]' : 'w-[300px]';

  return (
    <article
      className={`${postSize} px-2 py-4 relative flex shrink-0 flex-col gap-2`}
    >
      <div className="relative">
        <LikeButton liked={liked} />
        <img
          className="aspect-square rounded-lg w-full"
          src={imageUrl}
          alt={`${title} 대표 이미지`}
        />
        {variant === 'primary' && (
          <span className="absolute left-6 bottom-2 text-white text-8xl font-semibold">
            {order + 1}
          </span>
        )}
      </div>
      <section className="flex flex-col gap-2 px-4">
        <p className="text-gray-500 text-xl font-medium truncate">{title}</p>
        <div className="flex gap-3">
          <IconWithCounts
            icon={<CommentIcon className="w-4 h-4" />}
            count={commentCount}
          />
          <IconWithCounts
            icon={<HeartIcon className="w-4 h-4" />}
            count={likeCount}
          />
          <IconWithCounts
            icon={
              <StarIcon className="w-4 h-4 fill-[#FACC15] stroke-[#FACC15]" />
            }
            count={rating}
            rating
          />
        </div>
      </section>
    </article>
  );
}
