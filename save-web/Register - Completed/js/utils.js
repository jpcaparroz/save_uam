export function atLeastOneLetterAndSpace(str) {
    return (
      /^[A-Za-z\s]*$/.test(str) &&
      /[A-Za-z]/.test(str)
    );
}